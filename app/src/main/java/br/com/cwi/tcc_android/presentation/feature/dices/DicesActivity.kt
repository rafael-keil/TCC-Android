package br.com.cwi.tcc_android.presentation.feature.dices

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ActivityDicesBinding
import br.com.cwi.tcc_android.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.random.Random

class DicesActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityDicesBinding
    override val currentTab: Int = R.id.dices_menu
    private var diceSides = 20
    private var diceImage = R.drawable.ic_d20

    private var mSensorManager: SensorManager? = null
    private var mAccelerometer: Sensor? = null
    private var mShakeDetector: ShakeDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtonActions()
        rollDice()
        initSensor()
    }

    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(
            mShakeDetector,
            mAccelerometer,
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause() {
        mSensorManager!!.unregisterListener(mShakeDetector)
        super.onPause()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun setupButtonActions() {
        binding.btD4.setOnClickListener {
            diceSides = 4
            diceImage = R.drawable.ic_d4
            rollDice()
        }
        binding.btD6.setOnClickListener {
            diceSides = 6
            diceImage = R.drawable.ic_d6
            rollDice()
        }
        binding.btD8.setOnClickListener {
            diceSides = 8
            diceImage = R.drawable.ic_d8
            rollDice()
        }
        binding.btD10.setOnClickListener {
            diceSides = 10
            diceImage = R.drawable.ic_d10
            rollDice()
        }
        binding.btD12.setOnClickListener {
            diceSides = 12
            diceImage = R.drawable.ic_d12
            rollDice()
        }
        binding.btD20.setOnClickListener {
            diceSides = 20
            diceImage = R.drawable.ic_d20
            rollDice()
        }

        binding.btRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val result = Random.nextInt(1, diceSides + 1)

        binding.tvDice.text = result.toString()
        binding.ivDice.setImageResource(diceImage)
    }

    private fun initSensor() {
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mShakeDetector = ShakeDetector()
        mShakeDetector!!.setOnShakeListener(object : ShakeDetector.OnShakeListener {
            override fun onShake(count: Int) {
                rollDice()
                println("foi")
            }
        })
    }
}
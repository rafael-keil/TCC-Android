package br.com.cwi.tcc_android.presentation.feature.dices

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ActivityDicesBinding
import br.com.cwi.tcc_android.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class DicesActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityDicesBinding
    private val viewModel: DicesViewModel by viewModel()
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
        mSensorManager?.unregisterListener(mShakeDetector)
        super.onPause()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun setupButtonActions() {
        binding.btD4.setOnClickListener { setOnClick(4, R.drawable.ic_d4) }
        binding.btD6.setOnClickListener { setOnClick(6, R.drawable.ic_d6) }
        binding.btD8.setOnClickListener { setOnClick(8, R.drawable.ic_d8) }
        binding.btD10.setOnClickListener { setOnClick(10, R.drawable.ic_d10) }
        binding.btD12.setOnClickListener { setOnClick(12, R.drawable.ic_d12) }
        binding.btD20.setOnClickListener { setOnClick(20, R.drawable.ic_d20) }

        binding.btRoll.setOnClickListener { rollDice() }
    }

    private fun setOnClick(sides: Int, image: Int) {
        diceSides = sides
        diceImage = image
        rollDice()
    }

    private fun rollDice() {
        binding.tvDice.text = viewModel.rollDice(diceSides).toString()
        binding.ivDice.setImageResource(diceImage)
    }

    private fun initSensor() {
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager?
        mAccelerometer = mSensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mShakeDetector = ShakeDetector()
        mShakeDetector?.setOnShakeListener(object : ShakeDetector.OnShakeListener {
            override fun onShake(count: Int) {
                rollDice()
            }
        })
    }
}
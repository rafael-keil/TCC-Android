package br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentEquipmentDetailBinding
import br.com.cwi.tcc_android.domain.entity.Equipment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val TAB = "      "
private const val BREAK_LINE = "\n"
private const val BONUS = "+ Dexterity"
private const val YES = "Yes"
private const val NO = "No"

class SpellDetailFragment : Fragment() {

    private lateinit var binding: FragmentEquipmentDetailBinding

    private val viewModel: EquipmentDetailViewModel by sharedViewModel()


    private val itemId by lazy {
        arguments?.getString("id")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.equipmentDetail.observe(viewLifecycleOwner) { item ->
            setupDetailsInfo(item)
        }

        itemId?.run {
            viewModel.fetchEquipment(this)
        }
    }

    private fun setupDetailsInfo(item: Equipment) {
        item.run {
            binding.tvName.text = name
            binding.tvEquipmentCategoryContent.text = equipmentCategory.name
            binding.tvCostContent.text =
                getString(R.string.txt_content_cost, cost.quantity, cost.unit)
            binding.tvWeightContent.text = getString(R.string.txt_content_weight, weight ?: 0.0)

            desc?.let {
                binding.tvDesc.visibility = View.VISIBLE
                binding.tvDesc.text = it.joinToString(separator = BREAK_LINE + TAB, prefix = TAB)
            }

            properties?.let { properties ->
                binding.clWeaponInfo.visibility = View.VISIBLE
                binding.tvWeaponCategoryContent.text = weaponCategory
                binding.tvWeaponRangeContent.text = weaponRange
                binding.tvDamageContent.text = getString(
                    R.string.txt_content_damage,
                    damage?.damageDice,
                    damage?.damageType?.name
                )
                binding.lvPropertiesContent.adapter =
                    context?.let { context ->
                        ArrayAdapter(
                            context,
                            R.layout.item_detail_basic,
                            properties.map { it.name }
                        )
                    }
            }

            armorCategory?.let {
                binding.clArmorInfo.visibility = View.VISIBLE
                binding.tvArmorCategoryContent.text = armorCategory
                binding.tvArmorClassContent.text = getString(
                    R.string.txt_content_armor_class,
                    armorClass?.base,
                    if (armorClass?.dexBonus == true) BONUS else ""
                )
                binding.tvStrMinimumContent.text = strMinimum?.toString() ?: NO
                binding.tvStealthDisadvantageContent.text =
                    if (stealthDisadvantage == true) YES else NO
            }
        }
    }
}
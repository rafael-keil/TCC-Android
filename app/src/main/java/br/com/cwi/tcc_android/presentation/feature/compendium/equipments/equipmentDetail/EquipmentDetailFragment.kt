package br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentEquipmentDetailBinding
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.presentation.base.BaseFavoriteFragment
import br.com.cwi.tcc_android.presentation.base.ID
import br.com.cwi.tcc_android.presentation.base.IS_FAVORITE
import br.com.cwi.tcc_android.presentation.feature.compendium.equipments.EquipmentViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val TAB = "      "
private const val BREAK_LINE = "\n"
private const val BONUS = "+ Dexterity"
private const val YES = "Yes"
private const val NO = "No"

class EquipmentDetailFragment : BaseFavoriteFragment() {

    private lateinit var binding: FragmentEquipmentDetailBinding
    private val superViewModel: EquipmentViewModel by sharedViewModel()
    private val viewModel: EquipmentDetailViewModel by sharedViewModel()
    private lateinit var equipment: Equipment

    private val itemId by lazy {
        arguments?.getString(ID)
    }
    private val itemIsFavorite by lazy {
        arguments?.getBoolean(IS_FAVORITE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEquipmentDetailBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.equipmentDetail.observe(viewLifecycleOwner) { item ->
            equipment = item
            equipment.isFavorite = itemIsFavorite!!
            setupDetailsInfo()
        }

        itemId?.run {
            viewModel.fetchEquipment(this)
        }
    }

    private fun setupDetailsInfo() {
        equipment.run {
            favoriteIcon?.icon = AppCompatResources.getDrawable(
                requireContext(),
                if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite
            )

            binding.tvName.text = name
            binding.tvEquipmentCategoryContent.text = equipmentCategory
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
                    damage?.damageType
                )
                binding.lvPropertiesContent.adapter =
                    context?.let { context ->
                        ArrayAdapter(
                            context,
                            R.layout.item_detail_basic,
                            properties
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

    override fun onFavoriteClick() {
        equipment.isFavorite = !equipment.isFavorite
        superViewModel.setFavorite(equipment)
        setupDetailsInfo()
    }
}
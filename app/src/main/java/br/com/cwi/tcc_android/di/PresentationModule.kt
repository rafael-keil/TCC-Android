package br.com.cwi.tcc_android.di

import br.com.cwi.tcc_android.presentation.feature.compendium.equipments.EquipmentViewModel
import br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentDetail.EquipmentDetailViewModel
import br.com.cwi.tcc_android.presentation.feature.compendium.spells.SpellViewModel
import br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellDetail.SpellDetailViewModel
import br.com.cwi.tcc_android.presentation.feature.dices.DicesViewModel
import br.com.cwi.tcc_android.presentation.feature.favorites.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { SpellViewModel(get(), get()) }
    viewModel { SpellDetailViewModel(get(), get()) }
    viewModel { EquipmentViewModel(get(), get()) }
    viewModel { EquipmentDetailViewModel(get(), get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DicesViewModel() }
}
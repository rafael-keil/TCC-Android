package br.com.cwi.tcc_android.di

import br.com.cwi.tcc_android.presentation.feature.compendium.spells.SpellViewModel
import br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellDetail.SpellDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { SpellViewModel(get()) }
    viewModel { SpellDetailViewModel(get()) }
}
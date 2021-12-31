package br.com.cwi.tcc_android.di

import br.com.cwi.tcc_android.presentation.feature.compendium.`class`.ClassViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ClassViewModel(get()) }
}
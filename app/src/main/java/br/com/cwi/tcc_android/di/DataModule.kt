package br.com.cwi.tcc_android.di

import br.com.cwi.tcc_android.data.network.RetrofitConfig
import br.com.cwi.tcc_android.data.network.mapper.*
import br.com.cwi.tcc_android.data.repository.DndRepositoryImpl
import br.com.cwi.tcc_android.domain.repository.DndRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { AbilityScoreMapper() }
    single { BaseChooseMapper() }
    single { BaseListItemMapper() }
    single { ChooseOptionMapper() }
    single { ClassMapper() }
    single { MultiClassingMapper() }
    single { StartingEquipmentMapper() }

    factory<DndRepository> { DndRepositoryImpl(get(), get()) }
}
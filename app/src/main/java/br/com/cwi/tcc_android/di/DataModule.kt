package br.com.cwi.tcc_android.di

import br.com.cwi.tcc_android.data.network.RetrofitConfig
import br.com.cwi.tcc_android.data.network.mapper.BaseListItemMapper
import br.com.cwi.tcc_android.data.network.mapper.EquipmentMapper
import br.com.cwi.tcc_android.data.network.mapper.SpellMapper
import br.com.cwi.tcc_android.data.repository.DndRepositoryImpl
import br.com.cwi.tcc_android.domain.repository.DndRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { SpellMapper() }
    single { BaseListItemMapper() }
    single { EquipmentMapper() }

    factory<DndRepository> { DndRepositoryImpl(get(), get(), get()) }
}
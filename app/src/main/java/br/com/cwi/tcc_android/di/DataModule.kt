package br.com.cwi.tcc_android.di

import br.com.cwi.tcc_android.data.network.RetrofitConfig
import br.com.cwi.tcc_android.data.repository.DndRepositoryImpl
import br.com.cwi.tcc_android.domain.repository.DndRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    factory<DndRepository> { DndRepositoryImpl(get()) }
}
package br.com.cwi.tcc_android.di

import br.com.cwi.tcc_android.data.database.AppDatabase
import br.com.cwi.tcc_android.data.network.RetrofitConfig
import br.com.cwi.tcc_android.data.repository.DndLocalRepositoryImpl
import br.com.cwi.tcc_android.data.repository.DndRepositoryImpl
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.domain.repository.DndRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }
    single { AppDatabase.create(androidApplication()) }

    factory<DndRepository> { DndRepositoryImpl(get()) }
    factory<DndLocalRepository> { DndLocalRepositoryImpl(get()) }
}
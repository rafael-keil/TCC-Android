package br.com.cwi.tcc_android.data.network

import br.com.cwi.tcc_android.data.network.entity.ClassResponse
import retrofit2.http.GET

interface DndApi {

    @GET("/classes")
    suspend fun getClasses(): List<ClassResponse>
}
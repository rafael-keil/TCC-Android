package br.com.cwi.tcc_android.data.network

import br.com.cwi.tcc_android.data.network.entity.EquipmentResponse
import br.com.cwi.tcc_android.data.network.entity.SpellResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DndApi {

    @GET("/spells")
    suspend fun getSpells(): List<SpellResponse>

    @GET("/spells/{id}")
    suspend fun getSpell(@Path("id") id: String): SpellResponse

    @GET("/equipments")
    suspend fun getEquipments(): List<EquipmentResponse>

    @GET("/equipments/{id}")
    suspend fun getEquipment(@Path("id") id: String): EquipmentResponse
}
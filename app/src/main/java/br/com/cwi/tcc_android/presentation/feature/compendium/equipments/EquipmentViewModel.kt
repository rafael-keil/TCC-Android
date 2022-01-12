package br.com.cwi.tcc_android.presentation.feature.compendium.equipments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.data.database.entity.EquipmentEntity
import br.com.cwi.tcc_android.data.database.mapper.toEntity
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

class EquipmentViewModel(
    private val dndRepository: DndRepository,
    private val dndLocalRepository: DndLocalRepository,
) : BaseViewModel() {

    private val _equipments = MutableLiveData<List<Equipment>>()
    val equipments: LiveData<List<Equipment>> = _equipments

    fun fetchEquipments() {
        launch {
            val equipmentsList = dndRepository.getEquipments()
            val favoriteList = dndLocalRepository.getAllEquipments()
            _equipments.postValue(setIsEquipmentFavorite(favoriteList, equipmentsList))
        }
    }


    private fun setIsEquipmentFavorite(
        favoriteIdList: List<EquipmentEntity>,
        equipmentList: List<Equipment>
    ): List<Equipment> {
        favoriteIdList.forEach { favorite ->
            equipmentList.find { it.id == favorite.id }?.isFavorite = true
        }
        return equipmentList
    }

    fun setFavorite(equipment: Equipment) {
        val equipmentEntity = equipment.toEntity()
        if (equipment.isFavorite) dndLocalRepository.add(equipmentEntity)
        else dndLocalRepository.remove(equipmentEntity)
    }
}
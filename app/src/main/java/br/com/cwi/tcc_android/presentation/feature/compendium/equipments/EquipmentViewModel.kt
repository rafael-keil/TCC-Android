package br.com.cwi.tcc_android.presentation.feature.compendium.equipments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

open class EquipmentViewModel(
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
        favoriteIdList: List<Equipment>,
        equipmentList: List<Equipment>
    ): List<Equipment> {
        favoriteIdList.forEach { favorite ->
            equipmentList.find { it.id == favorite.id }?.isFavorite = true
        }
        return equipmentList
    }

    fun setFavorite(equipment: Equipment) {
        if (equipment.isFavorite) dndLocalRepository.add(equipment)
        else dndLocalRepository.remove(equipment)
    }
}
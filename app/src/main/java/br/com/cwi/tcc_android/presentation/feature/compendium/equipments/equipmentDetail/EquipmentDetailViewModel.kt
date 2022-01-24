package br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.feature.compendium.equipments.EquipmentViewModel

class EquipmentDetailViewModel(
    private val dndRepository: DndRepository,
    dndLocalRepository: DndLocalRepository,
) : EquipmentViewModel(dndRepository, dndLocalRepository) {

    private val _equipmentDetail = MutableLiveData<Equipment>()
    val equipmentDetail: LiveData<Equipment> = _equipmentDetail

    fun fetchEquipment(id: String) {
        launch {
            val equipment = dndRepository.getEquipment(id)
            _equipmentDetail.postValue(equipment)
        }
    }
}
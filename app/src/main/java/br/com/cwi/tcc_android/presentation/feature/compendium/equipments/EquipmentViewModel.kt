package br.com.cwi.tcc_android.presentation.feature.compendium.equipments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

class EquipmentViewModel(
    private val dndRepository: DndRepository,
) : BaseViewModel() {

    private val _equipments = MutableLiveData<List<Equipment>>()
    val equipments: LiveData<List<Equipment>> = _equipments

    fun fetchEquipments() {
        launch {
            val equipmentsList = dndRepository.getEquipments()
            _equipments.postValue(equipmentsList)
        }
    }
}
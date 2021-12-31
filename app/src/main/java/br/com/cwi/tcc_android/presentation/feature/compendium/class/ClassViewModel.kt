package br.com.cwi.tcc_android.presentation.feature.compendium.`class`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Class
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

class ClassViewModel(
    private val dndRepository: DndRepository,
) : BaseViewModel() {

    private val _classes = MutableLiveData<List<Class>>()
    val classes: LiveData<List<Class>> = _classes

    fun fetchClasses() {
        launch {
            val classesList = dndRepository.getClasses()
            _classes.postValue(classesList)
        }
    }
}
package br.com.cwi.tcc_android.presentation.feature.compendium.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

class SpellViewModel(
    private val dndRepository: DndRepository,
) : BaseViewModel() {

    private val _classes = MutableLiveData<List<Spell>>()
    val classes: LiveData<List<Spell>> = _classes

    fun fetchSpells() {
        launch {
            val classesList = dndRepository.getSpells()
            _classes.postValue(classesList)
        }
    }
}
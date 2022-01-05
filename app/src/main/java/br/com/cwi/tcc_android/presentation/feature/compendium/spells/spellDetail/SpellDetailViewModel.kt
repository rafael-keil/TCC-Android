package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

class SpellDetailViewModel(
    private val dndRepository: DndRepository,
) : BaseViewModel() {

    private val _classDetail = MutableLiveData<Spell>()
    val classDetail: LiveData<Spell> = _classDetail

    fun fetchClasses(id: String) {
        launch {
            val classesList = dndRepository.getSpell(id)
            _classDetail.postValue(classesList)
        }
    }
}
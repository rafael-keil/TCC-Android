package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

class SpellDetailViewModel(
    private val dndRepository: DndRepository,
) : BaseViewModel() {

    private val _spellDetail = MutableLiveData<Spell>()
    val spellDetail: LiveData<Spell> = _spellDetail

    fun fetchSpell(id: String) {
        launch {
            val spell = dndRepository.getSpell(id)
            _spellDetail.postValue(spell)
        }
    }
}
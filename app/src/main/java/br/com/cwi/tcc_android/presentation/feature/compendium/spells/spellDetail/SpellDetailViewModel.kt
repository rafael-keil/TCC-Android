package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.feature.compendium.spells.SpellViewModel

class SpellDetailViewModel(
    private val dndRepository: DndRepository,
    dndLocalRepository: DndLocalRepository,
) : SpellViewModel(dndRepository, dndLocalRepository) {

    private val _spellDetail = MutableLiveData<Spell>()
    val spellDetail: LiveData<Spell> = _spellDetail

    fun fetchSpell(id: String) {
        launch {
            val spell = dndRepository.getSpell(id)
            _spellDetail.postValue(spell)
        }
    }
}
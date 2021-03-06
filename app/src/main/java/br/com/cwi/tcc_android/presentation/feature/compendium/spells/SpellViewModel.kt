package br.com.cwi.tcc_android.presentation.feature.compendium.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.domain.repository.DndRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

open class SpellViewModel(
    private val dndRepository: DndRepository,
    private val dndLocalRepository: DndLocalRepository,
) : BaseViewModel() {

    private val _spells = MutableLiveData<List<Spell>>()
    val spells: LiveData<List<Spell>> = _spells

    fun fetchSpells() {
        launch {
            val spellsList = dndRepository.getSpells()
            val favoriteList = dndLocalRepository.getAllSpells()
            _spells.postValue(setIsSpellFavorite(favoriteList, spellsList))
        }
    }

    private fun setIsSpellFavorite(
        favoriteIdList: List<Spell>,
        spellsList: List<Spell>
    ): List<Spell> {
        favoriteIdList.forEach { favorite ->
            spellsList.find { it.id == favorite.id }?.isFavorite = true
        }
        return spellsList
    }

    fun setFavorite(spell: Spell) {
        if (spell.isFavorite) dndLocalRepository.add(spell)
        else dndLocalRepository.remove(spell)
    }
}
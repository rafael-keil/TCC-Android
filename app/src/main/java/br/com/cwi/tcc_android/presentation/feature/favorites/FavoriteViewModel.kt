package br.com.cwi.tcc_android.presentation.feature.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.tcc_android.data.database.mapper.toDomain
import br.com.cwi.tcc_android.data.database.mapper.toEntity
import br.com.cwi.tcc_android.domain.entity.BaseCompendiumItem
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.presentation.base.BaseViewModel

class FavoriteViewModel(
    private val dndLocalRepository: DndLocalRepository,
) : BaseViewModel() {

    private val _favorites = MutableLiveData<List<BaseCompendiumItem>>()
    val favorites: LiveData<List<BaseCompendiumItem>> = _favorites

    fun fetchFavorites() {
        launch {
            val favoriteSpellList = dndLocalRepository.getAllSpells()
            val favoriteEquipmentList = dndLocalRepository.getAllEquipments()
            val favoriteList: List<BaseCompendiumItem> =
                favoriteSpellList.map { it.toDomain() } + favoriteEquipmentList.map { it.toDomain() }
            favoriteList.map { it.isFavorite = true }
            _favorites.postValue(favoriteList)
        }
    }

    fun setFavorite(item: BaseCompendiumItem) {
        if (item is Spell) dndLocalRepository.remove(item.toEntity())
        else dndLocalRepository.remove((item as Equipment).toEntity())

        fetchFavorites()
    }
}
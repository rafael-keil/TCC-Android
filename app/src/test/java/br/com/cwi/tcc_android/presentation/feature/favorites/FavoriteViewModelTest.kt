package br.com.cwi.tcc_android.presentation.feature.favorites

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.cwi.tcc_android.domain.entity.BaseCompendiumItem
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.fixture.EquipmentFixture
import br.com.cwi.tcc_android.fixture.SpellFixture
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class FavoriteViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: FavoriteViewModel
    private val dndLocalRepository: DndLocalRepository = mockk()
    private val favoritesObserver: Observer<List<BaseCompendiumItem>> = mockk()
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = FavoriteViewModel(dndLocalRepository)
        viewModel.favorites.observeForever(favoritesObserver)
    }

    @Test
    fun `when view model fetch favorites then return all favorites`() {
        val spells = SpellFixture.getSpellList()
        val equipments = EquipmentFixture.getEquipmentList()
        val favorites = spells + equipments
        favorites.map { it.isFavorite = true }

        every { dndLocalRepository.getAllSpells() } returns spells
        every { dndLocalRepository.getAllEquipments() } returns equipments

        viewModel.fetchFavorites()

        verify { favoritesObserver.onChanged(any()) }
        Assert.assertTrue(viewModel.favorites.value?.toTypedArray() contentEquals favorites.toTypedArray())
    }

    @Test
    fun `when view model setFavorite spell then remove spell`() {
        val spell = SpellFixture.getSpell()
        val spells = SpellFixture.getSpellList()
        val equipments = EquipmentFixture.getEquipmentList()

        justRun { dndLocalRepository.remove(spell) }
        every { dndLocalRepository.getAllSpells() } returns spells
        every { dndLocalRepository.getAllEquipments() } returns equipments

        viewModel.setFavorite(spell)

        verify { dndLocalRepository.remove(spell) }
        verify { viewModel.fetchFavorites() }
    }

    @Test
    fun `when view model setFavorite equipment then remove equipment`() {
        val equipment = EquipmentFixture.getEquipment()
        val spells = SpellFixture.getSpellList()
        val equipments = EquipmentFixture.getEquipmentList()

        justRun { dndLocalRepository.remove(equipment) }
        every { dndLocalRepository.getAllSpells() } returns spells
        every { dndLocalRepository.getAllEquipments() } returns equipments

        viewModel.setFavorite(equipment)

        verify { dndLocalRepository.remove(equipment) }
        verify { viewModel.fetchFavorites() }
    }
}
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
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
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
    private val favoritesObserver: Observer<List<BaseCompendiumItem>> = mockk(relaxed = true)
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = FavoriteViewModel(dndLocalRepository)
        viewModel.favorites.observeForever(favoritesObserver)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `when view model fetch favorites then return all favorites`() {
        every { dndLocalRepository.getAllSpells() } returns SpellFixture.getSpellList()
        every { dndLocalRepository.getAllEquipments() } returns EquipmentFixture.getEquipmentList()

        viewModel.fetchFavorites()

        verify {
            favoritesObserver.onChanged(
                match { item ->
                    item.all { it.isFavorite }
                }
            )
        }
    }

    @Test
    fun `when view model setFavorite spell then remove spell`() {
        val spell = SpellFixture.getSpell()

        justRun { dndLocalRepository.remove(spell) }
        every { dndLocalRepository.getAllSpells() } returns SpellFixture.getSpellList()
        every { dndLocalRepository.getAllEquipments() } returns EquipmentFixture.getEquipmentList()

        viewModel.setFavorite(spell)

        verify { dndLocalRepository.remove(spell) }
        verify { favoritesObserver.onChanged(any()) }
    }

    @Test
    fun `when view model setFavorite equipment then remove equipment`() {
        val equipment = EquipmentFixture.getEquipment()

        justRun { dndLocalRepository.remove(equipment) }
        every { dndLocalRepository.getAllSpells() } returns SpellFixture.getSpellList()
        every { dndLocalRepository.getAllEquipments() } returns EquipmentFixture.getEquipmentList()

        viewModel.setFavorite(equipment)

        verify { dndLocalRepository.remove(equipment) }
        verify { favoritesObserver.onChanged(any()) }
    }
}
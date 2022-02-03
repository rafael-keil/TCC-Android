package br.com.cwi.tcc_android.presentation.feature.favorites

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.cwi.tcc_android.domain.entity.BaseCompendiumItem
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository
import br.com.cwi.tcc_android.fixture.EquipmentFixture
import br.com.cwi.tcc_android.fixture.SpellFixture
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class FavoriteViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: FavoriteViewModel
    private val dndLocalRepository: DndLocalRepository = mockk()
    private val favoritesObserver = mockk<Observer<List<BaseCompendiumItem>>>(relaxed = true)
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `when view model fetch favorites then return all favorites`() {
        viewModel = FavoriteViewModel(dndLocalRepository)
        viewModel.favorites.observeForever(favoritesObserver)
        val spells = SpellFixture.getSpellList()
        val equipments = EquipmentFixture.getEquipmentList()

        coEvery { dndLocalRepository.getAllSpells() } returns spells
        coEvery { dndLocalRepository.getAllEquipments() } returns equipments

        viewModel.fetchFavorites()

        val favorites = spells + equipments
        //favorites.map { it.isFavorite = true }

        coVerify { favoritesObserver.onChanged(favorites) }
        Assert.assertEquals(viewModel.favorites.value, favorites)
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
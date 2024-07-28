package presentation.ui.meals

import kotlinx.coroutines.Dispatchers
import domain.meals.model.Meal
import domain.meals.repository.MealListRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import presentation.base.Result
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MealListViewModelTest {
    private val repository = mockk<MealListRepository>()

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun testSomething() = runTest {
        val meals = listOf(
            Meal(
                id = "id",
                name = "name",
                category = "category",
                area = "area",
                instructions = "ins",
                imageUrl = "url",
                tags = "tags",
                videoUrl = "url",
                ingredients = mapOf()
            )
        )

        coEvery { repository.getMeals(false) } returns meals
        val viewModel = MealListViewModel(repository)

        coVerify { repository.getMeals(false) }

        /*assertEquals(
            expected = (viewModel.meals.value as Result.Success<List<Meal>>).data,
            actual = meals
        )*/
    }
}
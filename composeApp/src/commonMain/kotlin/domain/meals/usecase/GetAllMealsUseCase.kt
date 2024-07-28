package domain.meals.usecase

import domain.meals.model.Meal
import domain.meals.repository.MealListRepository

interface GetAllMealsUseCase {
    suspend operator fun invoke(): List<Meal>
}

class GetAllMealsUseCaseImpl(
    private val mealListRepository: MealListRepository
) : GetAllMealsUseCase {
    override suspend fun invoke(): List<Meal> {
        return mealListRepository.getMeals(false)
    }
}
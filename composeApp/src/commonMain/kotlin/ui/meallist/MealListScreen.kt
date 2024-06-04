package ui.meallist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import org.koin.compose.koinInject

@Composable
fun FoodListScreen(
) {
   val viewModel: MealListViewModel = koinInject()
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
    }
}
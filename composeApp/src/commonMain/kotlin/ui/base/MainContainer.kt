package ui.base

import androidx.compose.runtime.Composable
import ui.meallist.FoodListScreen
import ui.theme.FoodiesAppTheme

@Composable
fun MainContainer() {
    FoodiesAppTheme {
        FoodListScreen()
    }
}
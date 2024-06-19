package ui.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.meallist.FoodListScreen
import ui.theme.FoodiesAppTheme

@Composable
fun MainContainer() {
    FoodiesAppTheme {
        FoodListScreen(modifier = Modifier.fillMaxSize())
    }
}
package presentation.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.ui.meals.FoodListScreen
import presentation.theme.FoodiesAppTheme

@Composable
fun MainContainer() {
    FoodiesAppTheme {
        FoodListScreen(modifier = Modifier.fillMaxSize())
    }
}
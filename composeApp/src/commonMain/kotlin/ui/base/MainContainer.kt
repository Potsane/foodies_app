package ui.base

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.meallist.FoodListScreen
import ui.theme.FoodiesAppTheme

@Composable
@Preview
fun MainContainer() {
    FoodiesAppTheme {
        FoodListScreen()
    }
}
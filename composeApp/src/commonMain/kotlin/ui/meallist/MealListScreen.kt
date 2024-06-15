package ui.meallist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import ui.components.MealItemCard
import ui.components.SearchBar
import ui.components.TagListView

@Composable
fun FoodListScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: MealListViewModel = koinInject()
    val meals = viewModel.meals.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Let's go, \nFind you Favourite meals",
            style = MaterialTheme.typography.titleLarge,
        )
        SearchBar(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {}

        TagListView(
            modifier = Modifier.padding(
                horizontal = 8.dp,
                vertical = 24.dp
            )
        )

        Text(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            color = MaterialTheme.colorScheme.primary,
            text = "All the meals",
            style = MaterialTheme.typography.titleLarge,
        )

        Column(
            modifier = modifier
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                columns = GridCells.Fixed(2)
            ) {

                itemsIndexed(meals.value) { _, item ->
                    MealItemCard(item, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
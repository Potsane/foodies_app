package ui.meallist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

        MealItemCard(modifier= Modifier.padding(16.dp))
    }
}
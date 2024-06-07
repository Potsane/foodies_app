package ui.meallist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import ui.components.SearchBar

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

    }
}
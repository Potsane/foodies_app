package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val categories = listOf(
    "General",
    "Beef",
    "Chicken",
    "Dessert",
    "Pasta",
    "Seafood",
    "Vegan",
    "Vegetarian",
    "Breakfast"
)

@Composable
fun TagListView(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf(0) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        LazyRow {
            itemsIndexed(
                items = categories,
            ) { index, item ->
                TagView(selectedItem = selectedItem, text = item, currentIndex = index) {
                    selectedItem = index
                }
            }
        }
    }
}

@Composable
fun TagView(
    selectedItem: Int,
    text: String,
    currentIndex: Int,
    modifier: Modifier = Modifier,
    onSelectionChanges: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .background(
                color = if (selectedItem == currentIndex) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp),
            )
            .wrapContentHeight()
            .padding(
                vertical = 8.dp,
                horizontal = 4.dp
            )
            .clickable(onClick = onSelectionChanges),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        //Icon(Icons.Default.Check, null, tint = Color.White)
        Text(
            color = Color.White,
            text = text,
        )
    }
}
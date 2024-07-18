package presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import domain.meals.model.Meal

@Composable
fun MealItemCard(
    item: Meal,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        ) {

            AsyncImage(
                model = item.imageUrl,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    maxLines = 3,
                    text = item.instructions,
                    style = MaterialTheme.typography.labelSmall,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            }
        }
    }
}
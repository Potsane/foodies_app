package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale.Companion.FillBounds
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ui.model.Meal

@Composable
fun MealItemCard(
    item: Meal,
    modifier: Modifier = Modifier
) {
    Box {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.wrapContentWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primary)
                    .wrapContentSize()
                    .padding(
                        vertical = 64.dp,
                        horizontal = 8.dp
                    ),
            ) {

                Text(
                    text = "This is the Meal name",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }
        }

        AsyncImage(
            model = item.imageUrl,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = (-40).dp)
                .size(120.dp)
                .clip(CircleShape),
            contentScale = FillBounds,
            contentDescription = null,
        )
    }
}

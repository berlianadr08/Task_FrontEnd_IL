package com.berliana.taskfrontendil.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.berliana.taskfrontendil.R
import com.berliana.taskfrontendil.model.Drink
import com.berliana.taskfrontendil.ui.theme.Shapes

@Composable
fun DrinkItem(
    drink: Drink,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Column {
            Image(
                painter = painterResource(drink.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp)
                    .clip(Shapes.medium)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = drink.title,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    text = drink.price,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CartItemPreview() {
    MaterialTheme {
        DrinkItem(
            drink = Drink(1, R.drawable.drink1, "Strawberry Frappuccino", "Rp 20.000", ""),
            modifier = Modifier.padding(8.dp)
        )
    }
}
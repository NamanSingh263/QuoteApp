package com.example.quotecomposeapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotecomposeapp.Models.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote:Quote) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(quote) }
            .fillMaxWidth(1f)

    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "nigga",
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        Color.Black
                    )
                    .rotate(180f),
                alignment = Alignment.TopStart

            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column (modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Box(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth(.4f)
                        .height(1.dp)
                )
                Text(
                    text = quote.author,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 4.dp)
                )

            }
        }

    }

}

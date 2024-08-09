package com.example.quotecomposeapp.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.quotecomposeapp.DataManager
import com.example.quotecomposeapp.Models.Quote
import com.example.quotecomposeapp.R

@Composable
fun QuoteDetail(quote: Quote) {
    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        colorResource(id = R.color.purple_200),
                        Color(0xFFe3e3e3)
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .padding(32.dp)
                .align(Alignment.Center)
                .fillMaxWidth(1f),
            colors = CardDefaults.cardColors(Color.White)
        )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(14.dp, 26.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f),
                )
                Text(
                    text = quote.text,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = quote.author,
                    fontFamily = FontFamily.Cursive,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
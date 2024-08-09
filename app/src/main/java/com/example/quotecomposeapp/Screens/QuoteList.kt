package com.example.quotecomposeapp.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import com.example.quotecomposeapp.Models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn(
        content = {
            items(data) {
                QuoteListItem(quote = it, onClick)
            }
        }
    )
}
package com.example.quotecomposeapp

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.quotecomposeapp.Screens.QuoteDetail
import com.example.quotecomposeapp.Screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            APP()
        }
    }
}


@Composable
fun APP() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.Listing) {
            QuoteListScreen(data = DataManager.data) {
                     DataManager.switchPages(quote = it) }
        } else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }

}
enum class Pages {
    Listing,
    Detail
}

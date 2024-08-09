package com.example.quotecomposeapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotecomposeapp.Models.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var currentPage = mutableStateOf(Pages.Listing)
    var currentQuote : Quote? = null
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context :Context){
        val inputStream = context.assets.open("details.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true
    }
    fun switchPages(quote: Quote?){
        if (currentPage.value == Pages.Listing){
            currentQuote = quote
            currentPage.value = Pages.Detail
        }else{
            currentPage.value = Pages.Listing
        }
    }

}
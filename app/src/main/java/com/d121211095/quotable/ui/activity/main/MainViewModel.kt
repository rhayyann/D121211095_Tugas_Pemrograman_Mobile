package com.d121211095.quotable.ui.activity.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211095.quotable.data.model.quote.Quote
import com.d121211095.quotable.data.repository.QuotableRepository
import com.d121211095.quotable.MyApplication
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val quotes: List<Quote>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val quotableRepository: QuotableRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getQuotes() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = quotableRepository.getQuotes()
            Log.d("MainViewModel", "getQuotes: ${result.results?.size}")
            mainUiState = MainUiState.Success(result.results.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewMode", "getNews error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getQuotes()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val quotableRepository = application.container.quotableRepository
                MainViewModel(quotableRepository)
            }
        }
    }

}
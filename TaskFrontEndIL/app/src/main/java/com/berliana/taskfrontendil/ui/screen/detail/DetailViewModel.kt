package com.berliana.taskfrontendil.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berliana.taskfrontendil.data.DrinkRepository
import com.berliana.taskfrontendil.model.SelectDrink
import com.berliana.taskfrontendil.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel (private val repository: DrinkRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<SelectDrink>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<SelectDrink>>
        get() = _uiState

    fun getDrinkById(drinkId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getSelectDrinkById(drinkId))
        }
    }
}
package com.berliana.taskfrontendil.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berliana.taskfrontendil.data.DrinkRepository
import com.berliana.taskfrontendil.model.SelectDrink
import com.berliana.taskfrontendil.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: DrinkRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<SelectDrink>>> = MutableStateFlow(UiState.Loading)
    private val _query = mutableStateOf("")
    private val _groupedDrinks = MutableStateFlow(
        repository.getDrinks()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )

    val uiState: StateFlow<UiState<List<SelectDrink>>>
        get() = _uiState
    val query: State<String>
        get() = _query

    fun getAllDrinks() {
        viewModelScope.launch {
            repository.getAllDrinks()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { selectDrinks ->
                    _uiState.value = UiState.Success(selectDrinks)
                }
        }
    }

    fun search(newQuery: String) {
        _query.value = newQuery
        viewModelScope.launch {
            repository.searchDrink(_query.value)
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { selectDrinks ->
                    _uiState.value = UiState.Success(selectDrinks)
                }
        }
    }
}
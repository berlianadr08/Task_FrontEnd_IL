package com.berliana.taskfrontendil.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.berliana.taskfrontendil.data.DrinkRepository
import com.berliana.taskfrontendil.ui.screen.detail.DetailViewModel
import com.berliana.taskfrontendil.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: DrinkRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
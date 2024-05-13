package com.berliana.taskfrontendil.di

import com.berliana.taskfrontendil.data.DrinkRepository

object Injection {
    fun provideRepository(): DrinkRepository {
        return DrinkRepository.getInstance()
    }
}
package com.berliana.taskfrontendil.data

import com.berliana.taskfrontendil.model.Drink
import com.berliana.taskfrontendil.model.SelectDrink
import com.berliana.taskfrontendil.model.dummyDrink
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class DrinkRepository {
    private val selectDrink = mutableListOf<SelectDrink>()

    init {
        if (selectDrink.isEmpty()) {
            dummyDrink.forEach {
                selectDrink.add(SelectDrink(it))
            }
        }
    }

    fun getDrinks(): List<Drink> {
        return dummyDrink
    }

    fun getAllDrinks(): Flow<List<SelectDrink>> {
        return flowOf(selectDrink)
    }

    fun getSelectDrinkById(drinkId: Long): SelectDrink {
        return selectDrink.first {
            it.drink.id == drinkId
        }
    }

    fun searchDrink(query: String): Flow<List<SelectDrink>> {
        return flow {
            emit(selectDrink.filter {
                it.drink.title.contains(query, ignoreCase = true)
            })
        }
    }

    companion object {
        @Volatile
        private var instance: DrinkRepository? = null

        fun getInstance(): DrinkRepository =
            instance ?: synchronized(this) {
                DrinkRepository().apply {
                    instance = this
                }
            }
    }
}
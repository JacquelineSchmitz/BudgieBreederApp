package de.syntaxinstitut.budgiebreeder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntaxinstitut.budgiebreeder.data.NestButtonDataSource
import de.syntaxinstitut.budgiebreeder.data.model.NestButton

class MainViewModel : ViewModel(){

    private val datasource = NestButtonDataSource()

    private val _nest = MutableLiveData<List<NestButton>>()
    val nesterFragment: LiveData<List<NestButton>>
    get() = _nest

    init {
        _nest.value = datasource.loadNestButton()
    }

    fun addToCart() {

    }
}
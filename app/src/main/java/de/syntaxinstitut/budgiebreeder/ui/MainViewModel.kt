package de.syntaxinstitut.budgiebreeder.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntaxinstitut.budgiebreeder.data.DataSource
import de.syntaxinstitut.budgiebreeder.ui.nest.NesterFragment

class MainViewModel : ViewModel(){

    private val datasource = DataSource()

    private val _nest = MutableLiveData<List<NesterFragment>>()
    val nesterFragment: LiveData<List<NesterFragment>>
    get() = _nest

    init {
   //     _nest.value = datasource.loadbirthdate()
    }

    fun addToCart() {

    }
}
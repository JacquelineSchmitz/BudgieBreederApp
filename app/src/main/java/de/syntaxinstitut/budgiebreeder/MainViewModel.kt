package de.syntaxinstitut.budgiebreeder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntaxinstitut.budgiebreeder.data.NestButtonDataSource
//import de.syntaxinstitut.budgiebreeder.data.PictureDataSource
import de.syntaxinstitut.budgiebreeder.data.Repository
import de.syntaxinstitut.budgiebreeder.data.model.NestButton
import de.syntaxinstitut.budgiebreeder.data.model.PicData
import de.syntaxinstitut.budgiebreeder.data.remote.BudgieApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val nestButtonDataSource = NestButtonDataSource()
    //private val picDataSource = PictureDataSource()
    private val repository = Repository(BudgieApi)

    private val _nest = MutableLiveData<List<NestButton>>()
    val nest: LiveData<List<NestButton>>
        get() = _nest

    //private val _pic = MutableLiveData<List<PicData>>()
    //val pic: LiveData<List<String>>
        //get() = _pic


    val pics: LiveData<List<String>> = repository.pictureslist


    init {
       // _nest.value = nestButtonDataSource.loadNestButton()
       // _pic.value = picDataSource.loadPictures()
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getPictures()
        }
    }
}



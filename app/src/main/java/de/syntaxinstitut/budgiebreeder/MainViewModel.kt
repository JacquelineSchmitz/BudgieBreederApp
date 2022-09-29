package de.syntaxinstitut.budgiebreeder

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Database
import de.syntaxinstitut.budgiebreeder.data.NestButtonDataSource
//import de.syntaxinstitut.budgiebreeder.data.PictureDataSource
import de.syntaxinstitut.budgiebreeder.data.Repository
import de.syntaxinstitut.budgiebreeder.data.local.DetailNestDataBase
import de.syntaxinstitut.budgiebreeder.data.local.getDatabase
import de.syntaxinstitut.budgiebreeder.data.model.DetailNest
import de.syntaxinstitut.budgiebreeder.data.model.NestButton
import de.syntaxinstitut.budgiebreeder.data.model.PicData
import de.syntaxinstitut.budgiebreeder.data.remote.BudgieApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val nestButtonDataSource = NestButtonDataSource()
    //private val picDataSource = PictureDataSource()

    private val dataBase = getDatabase(application)

    private val repository = Repository(BudgieApi, dataBase)

    private val _nest = MutableLiveData<List<NestButton>>()
    val nest: LiveData<List<NestButton>>
        get() = _nest

    val detailNest = repository.detailNestList
    val flirtData = repository.flirtDataList

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

    fun insertNest (detailNest: DetailNest){
        viewModelScope.launch {
            repository.insertNest(detailNest)
        }

    }
    fun deleteNest (id: Long) {
        viewModelScope.launch {
            repository.deleteDetailNest(id)
        }
    }

    fun updatedetailNest (detailNest: DetailNest){
        viewModelScope.launch {
            repository.updateDetailNest(detailNest)
        }
    }
}



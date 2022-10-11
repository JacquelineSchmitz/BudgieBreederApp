package de.syntaxinstitut.budgiebreeder

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Database
import de.syntaxinstitut.budgiebreeder.data.NestButtonDataSource
//import de.syntaxinstitut.budgiebreeder.data.PictureDataSource
import de.syntaxinstitut.budgiebreeder.data.Repository
import de.syntaxinstitut.budgiebreeder.data.local.DetailNestDataBase
import de.syntaxinstitut.budgiebreeder.data.local.getDatabase
import de.syntaxinstitut.budgiebreeder.data.model.*
import de.syntaxinstitut.budgiebreeder.data.remote.BudgieApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val nestButtonDataSource = NestButtonDataSource()
    //private val picDataSource = PictureDataSource()

    private val dataBase = getDatabase(application)

    private val repository = Repository(BudgieApi, dataBase)

    private val _nest = MutableLiveData<List<NestButton>>()
    val nest: LiveData<List<NestButton>>
        get() = _nest

//    private val _flirt = MutableLiveData<List<FlirtData>>()
//    val flirt: LiveData<List<FlirtData>>
//        get() = _flirt

    val detailNest = repository.detailNestList
    val flirtData = repository.flirtDataList
    val eiData = repository.eitDataList


    val pics: LiveData<List<String>> = repository.pictureslist

  //  val flirt: LiveData<List<String>> = repository.pictureslist



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

    fun insertNest(detailNest: DetailNest) {
        viewModelScope.launch {
            repository.insertNest(detailNest)
        }
    }

        fun insertEiData(eiData: EiData) {
            viewModelScope.launch {
                repository.insertEiData(eiData)
            }

        }

    fun insertFlirtData(flirtData: FlirtData) {
        viewModelScope.launch {
            repository.insertFlirt(flirtData)
        }

    }

        fun deleteNest(id: Long) {
            viewModelScope.launch {
                repository.deleteDetailNest(id)
            }
        }
    fun deleteEi(id: Long) {
        viewModelScope.launch {
            repository.deleteEiData(id)
        }
    }
    fun deleteFlirt(id: Long) {
        viewModelScope.launch {
            repository.deleteFlirtData(id)
        }
    }

        fun updatedetailNest(detailNest: DetailNest) {
            viewModelScope.launch {
                repository.updateDetailNest(detailNest)
            }
        }


        fun updateEiData(eiData: EiData) {
            viewModelScope.launch {
                repository.updateEiData(eiData)
            }
        }

    fun updateFlirtData(flirtData: FlirtData) {
        viewModelScope.launch {
            repository.updateFlirtData(flirtData)
        }
    }
    }




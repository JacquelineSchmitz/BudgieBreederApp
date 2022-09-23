package de.syntaxinstitut.budgiebreeder.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.budgiebreeder.data.model.PicData
import de.syntaxinstitut.budgiebreeder.data.remote.BudgieApi

class Repository(private val budgieApi: BudgieApi) {

   private val _picturesList = MutableLiveData<List<String>> ()
           val pictureslist: LiveData<List<String>>
            get() = _picturesList

    suspend fun getPictures(){
        _picturesList.value = budgieApi.retrofitService.getPictures()
    }
}
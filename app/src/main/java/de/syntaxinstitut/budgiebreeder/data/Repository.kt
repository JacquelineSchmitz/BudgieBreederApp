package de.syntaxinstitut.budgiebreeder.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.budgiebreeder.data.local.DetailNestDataBase
import de.syntaxinstitut.budgiebreeder.data.model.DetailNest
import de.syntaxinstitut.budgiebreeder.data.model.EiData
import de.syntaxinstitut.budgiebreeder.data.model.FlirtData
import de.syntaxinstitut.budgiebreeder.data.model.PicData
import de.syntaxinstitut.budgiebreeder.data.remote.BudgieApi
import java.util.*

class Repository(private val budgieApi: BudgieApi, private val dataBase: DetailNestDataBase) {

    val detailNestList: LiveData<List<DetailNest>> =
        dataBase.detailNestDataBaseDao.getAllDetailNest()
    val flirtDataList: LiveData<List<FlirtData>> =
        dataBase.detailNestDataBaseDao.getAllFlirtData()
    val eitDataList: LiveData<List<EiData>> =
        dataBase.detailNestDataBaseDao.getAllEiData()

   private val _picturesList = MutableLiveData<List<String>> ()
           val pictureslist: LiveData<List<String>>
            get() = _picturesList

    suspend fun getPictures(){
        _picturesList.value = budgieApi.retrofitService.getPictures()
    }

    suspend fun insertNest(detailNest: DetailNest) {
        try {
            dataBase.detailNestDataBaseDao.insertDetailNest(detailNest)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }
    }
    suspend fun insertFlirt(flirtData: FlirtData) {
        try {
            dataBase.detailNestDataBaseDao.insertFlirtData(flirtData)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }

    }
    suspend fun insertEiData(eiData: EiData) {
        try {
            dataBase.detailNestDataBaseDao.insertEiData(eiData)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }

    }

    suspend fun deleteDetailNest(id: Long) {
        try {
            dataBase.detailNestDataBaseDao.deleteDetailNest(id)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }
    }

    suspend fun deleteFlirtData(id: Long) {
        try {
            dataBase.detailNestDataBaseDao.deleteFlirtData(id)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }
    }
    suspend fun deleteEiData(id: Long) {
        try {
            dataBase.detailNestDataBaseDao.deleteEiData(id)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }
    }

    suspend fun updateDetailNest(detailNest: DetailNest) {
        try {
            dataBase.detailNestDataBaseDao.updateDetailNest(detailNest)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }
    }
    suspend fun updateFlirtData(flirtData: FlirtData) {
        try {
            dataBase.detailNestDataBaseDao.updateFlirtData(flirtData)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }
    }
    suspend fun updateEiData(eiData: EiData) {
        try {
            dataBase.detailNestDataBaseDao.upDateEiData(eiData)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to insert into database: $e")
        }
    }

}

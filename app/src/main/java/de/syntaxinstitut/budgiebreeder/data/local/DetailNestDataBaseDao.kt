package de.syntaxinstitut.budgiebreeder.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.syntaxinstitut.budgiebreeder.data.model.DetailNest
import de.syntaxinstitut.budgiebreeder.data.model.EiData
import de.syntaxinstitut.budgiebreeder.data.model.FlirtData
import java.util.*

@Dao
interface DetailNestDataBaseDao {

    @Update
    suspend fun updateDetailNest (detailNest: DetailNest)

    @Update
    suspend fun updateFlirtData (flirtData: FlirtData)

    @Update
    suspend fun upDateEiData (eiData: EiData)

    @Query("Delete From FlirtData Where id = :id")
    suspend fun deleteFlirtData (id: Long)

    @Query("Delete From DetailNest Where id = :id")
    suspend fun deleteDetailNest (id: Long)

    @Query("Delete From EiData Where id = :id")
    suspend fun deleteEiData (id: Long)

    @Insert
    suspend fun insertFlirtData (flirtData: FlirtData)

    @Insert
    suspend fun insertDetailNest (detailNest: DetailNest)

    @Insert
    suspend fun insertEiData (eiData: EiData)

    @Query("Select birthdate From DetailNest")
    suspend fun getBirthdate () : String

    @Query("Select placeddate From DetailNest")
    suspend fun getPlaceddate () : String

    @Query ("SELECT * FROM DetailNest")
    fun getAllDetailNest(): LiveData<List<DetailNest>>

    @Query ("SELECT * FROM FlirtData")
    fun getAllFlirtData(): LiveData<List<FlirtData>>

    @Query ("SELECT * FROM EiData")
    fun getAllEiData(): LiveData<List<EiData>>
}
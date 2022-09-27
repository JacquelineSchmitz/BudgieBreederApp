package de.syntaxinstitut.budgiebreeder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.syntaxinstitut.budgiebreeder.data.model.DetailNest
import kotlinx.coroutines.selects.select
import java.util.*

@Dao
interface DetailNestDataBaseDao {
//    @Insert
//    suspend fun insert (date: Date)
//    // @Query("Delete From DetailNest Where id = :id")
//    // suspend fun delete (id: Long)
//    @Query("Select birthdate From DetailNest")
//    suspend fun getBirthdate () : List<Date>
//    @Query("Select placeddate From DetailNest")
//    suspend fun getPlacedDate () : List<Date>
    @Update
    suspend fun update (date: Date)

}
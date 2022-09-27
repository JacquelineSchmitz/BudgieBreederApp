package de.syntaxinstitut.budgiebreeder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.syntaxinstitut.budgiebreeder.data.model.FlirtData


@Dao
interface FlirtDataBaseDao {
    @Insert
    suspend fun insert (flirtData: FlirtData)
     @Query("Delete From FlirtData Where id = :id")
     suspend fun delete (id: Long)
    @Update
    suspend fun update (flirtData: FlirtData)
}

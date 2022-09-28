package de.syntaxinstitut.budgiebreeder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.budgiebreeder.data.model.DetailNest
import de.syntaxinstitut.budgiebreeder.data.model.FlirtData


@Database(entities = [DetailNest::class, FlirtData::class], version = 1)
abstract class DetailNestDataBase : RoomDatabase() {
    abstract val detailNestDataBaseDao : DetailNestDataBaseDao
}


private lateinit var INSTANCE : DetailNestDataBase

fun getDatabase(context: Context): DetailNestDataBase{
    synchronized(DetailNestDataBase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                DetailNestDataBase::class.java,
                "budgie_database"
            ).build()
        }
        //return INSTANCE
    }

    return INSTANCE
}
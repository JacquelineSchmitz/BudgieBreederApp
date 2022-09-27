package de.syntaxinstitut.budgiebreeder.data.local

import de.syntaxinstitut.budgiebreeder.data.model.FlirtData



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FlirtData::class], version = 1)
abstract class FlirtDataBase : RoomDatabase() {
    abstract val flirtDatabaseDao : FlirtDataBaseDao
}


private lateinit var INSTANCE : FlirtDataBase

fun getFlirtDatabase(context: Context): FlirtDataBase{
    synchronized(FlirtDataBase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                FlirtDataBase::class.java,
                "budgie_database"
            ).build()
        }
    }

    return INSTANCE
}
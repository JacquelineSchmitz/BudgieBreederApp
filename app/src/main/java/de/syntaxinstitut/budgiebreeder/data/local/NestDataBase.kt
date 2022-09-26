package de.syntaxinstitut.budgiebreeder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.budgiebreeder.data.model.NestButton

@Database(entities = [NestButton::class], version = 1)
abstract class NestDataBase : RoomDatabase() {
    abstract val nestDatabaseDao : NestDataBaseDao
}


private lateinit var INSTANCE : NestDataBase

fun getNestDatabase(context: Context): NestDataBase{
    synchronized(NestDataBase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                NestDataBase::class.java,
                "budgie_database"
            ).build()
        }
    }

    return INSTANCE
}
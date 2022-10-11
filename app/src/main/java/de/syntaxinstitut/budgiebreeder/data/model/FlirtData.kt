package de.syntaxinstitut.budgiebreeder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FlirtData (
    @PrimaryKey (autoGenerate = true)
    val id : Long = 0,
    var name1 : String,
    var name2 : String
        )
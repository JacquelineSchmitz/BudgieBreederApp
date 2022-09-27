package de.syntaxinstitut.budgiebreeder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FlirtData (
    @PrimaryKey (autoGenerate = true)
    val id : Long = 0,
    val name1 : String,
    val name2 : String
        )
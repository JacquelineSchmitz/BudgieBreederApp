package de.syntaxinstitut.budgiebreeder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NestButton (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val name : String,
    )
package de.syntaxinstitut.budgiebreeder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//erst wichtig wenn datenbank umgesetzt wird
@Entity
data class DetailNest (
    @PrimaryKey (autoGenerate = true)
    val id : Long = 0,
    var title : String,
    var name : String,
    var placeddate : String,
    var birthdate : String
        )
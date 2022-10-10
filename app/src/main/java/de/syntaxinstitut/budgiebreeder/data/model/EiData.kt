package de.syntaxinstitut.budgiebreeder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EiData (
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        var gelegt: String,
        var geschluepft: String,
        val nestId: Long
        )
package de.syntaxinstitut.budgiebreeder.data.model

import com.squareup.moshi.Json

data class PicData (
    //val pictures: String,
    @Json( name = "ImageSrc")
    val imageSrc: String
        )
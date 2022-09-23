package de.syntaxinstitut.budgiebreeder.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntaxinstitut.budgiebreeder.data.model.PicData
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://public.syntax-institut.de/apps/batch2/JacquelineSchmitz/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BudgieApiService{

    @GET("data.json")
    suspend fun getPictures(): List<String>
}

object BudgieApi{
    val retrofitService: BudgieApiService by lazy { retrofit.create(BudgieApiService::class.java) }
}
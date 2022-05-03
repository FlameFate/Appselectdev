package com.example.appselectdev

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/reviews/search.json?&api-key=b1DiD8WqCZFoxJT7fA8PxLyil8Zvsk0U")
    fun getMovies() : Call<TestDC>

    companion object {

        var BASE_URL = "https://api.nytimes.com/svc/movies/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}
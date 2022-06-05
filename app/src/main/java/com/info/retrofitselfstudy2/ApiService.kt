package com.info.retrofitselfstudy2

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("v2/all")
    fun getCountries():Call<List<CountriesItem>>

}
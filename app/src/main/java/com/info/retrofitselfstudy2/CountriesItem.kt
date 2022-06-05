package com.info.retrofitselfstudy2


import com.google.gson.annotations.SerializedName

data class CountriesItem(
    @SerializedName("area")
    val area: String,
    @SerializedName("capital")
    val capital: String,
    @SerializedName("currencies")
    val currencies: List<Currency>,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("region")
    val region: String,
    @SerializedName("subregion")
    val subregion: String
)
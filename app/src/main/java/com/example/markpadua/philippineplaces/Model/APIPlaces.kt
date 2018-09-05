package com.example.markpadua.philippineplaces.Model

import com.example.markpadua.philippineplaces.Model.PlaceList
import retrofit2.Call
import retrofit2.http.GET

interface APIPlaces {

    @GET("https://sampleapi2.herokuapp.com/getplaces?location=manila")
    fun myJSON():Call<PlaceList>
}
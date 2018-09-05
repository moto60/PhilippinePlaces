package com.example.markpadua.philippineplaces.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaceList {

    @SerializedName("places")
    @Expose
    var places : ArrayList<places>? =null
}
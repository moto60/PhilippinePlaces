package com.example.markpadua.philippineplaces.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class places {

    @SerializedName("name")
    @Expose
    val name : String? = null
    @SerializedName("photo")
    @Expose
    val photo: String? = null
    @SerializedName("long")
    @Expose
    val long: String? = null
    @SerializedName("lat")
    @Expose
    val  lat : String? = null
    @SerializedName("phone")
    @Expose
    val phone:String? = null
    @SerializedName("email")
    @Expose
    val email:String? = null
}
package com.example.markpadua.philippineplaces.Contract

import com.example.markpadua.philippineplaces.Model.places

interface IRetroView{
    fun response(placeList:ArrayList<places>?)
    fun onFailed()
}
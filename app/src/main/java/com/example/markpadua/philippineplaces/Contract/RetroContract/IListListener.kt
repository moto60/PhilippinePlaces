package com.example.markpadua.philippineplaces.Contract.RetroContract

interface IListListener{
    fun onNavClick(lat: String?,long: String?,name:String?)
    fun onCallClick(phone:String?)
    fun onEmailClick(email: String?)
}
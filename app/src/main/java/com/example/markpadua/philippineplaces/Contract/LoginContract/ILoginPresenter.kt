package com.example.markpadua.philippineplaces.Contract.LoginContract

interface ILoginPresenter {

    fun login(username : String, password:String)
    fun setView(view: ILoginView)

}
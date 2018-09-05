package com.example.markpadua.philippineplaces.Presenter.LoginPresenters

import com.example.markpadua.philippineplaces.Contract.LoginContract.ILoginPresenter
import com.example.markpadua.philippineplaces.Contract.LoginContract.ILoginView


class LoginPresenter: ILoginPresenter {

    private lateinit var  loginview: ILoginView

    override fun setView(view: ILoginView) {
        loginview = view
    }


    override fun login(username: String, password: String) {

        if(username == "user1" && password == "password"){
            //success
            loginview.loginsuccess()

        }else{
            //failed
            loginview.loginfailed()
        }
    }


}
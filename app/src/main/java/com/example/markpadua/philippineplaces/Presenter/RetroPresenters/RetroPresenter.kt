package com.example.markpadua.philippineplaces.Presenter.RetroPresenters

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.markpadua.philippineplaces.Model.PlaceList
import com.example.markpadua.philippineplaces.Contract.LoginContract.ILoginPresenter
import com.example.markpadua.philippineplaces.Contract.IRetroPresenter
import com.example.markpadua.philippineplaces.Contract.IRetroView
import com.example.markpadua.philippineplaces.Model.places
import com.example.markpadua.philippineplaces.Presenter.RetroPresenters.RetroInstantiate

class RetroPresenter : IRetroPresenter {


    private lateinit var  retroview: IRetroView
    private lateinit var presenterlist : PlaceList
    private var placeList: ArrayList<places>?   = null


    override fun setView(view: IRetroView) {

        retroview = view

    }


    fun jsons(){

        val api = RetroInstantiate.retroInstantiate
        api.myJSON().enqueue(object : Callback<PlaceList> {

            override fun onResponse(call: Call<PlaceList>, response: Response<PlaceList>) {

                placeList = response?.body()!!.places
                retroview.response(placeList)

            }

            override fun onFailure(call: Call<PlaceList>, t: Throwable) {

               retroview.onFailed()

            }

        })

    }





}
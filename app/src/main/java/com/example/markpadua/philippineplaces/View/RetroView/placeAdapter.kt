package com.example.markpadua.philippineplaces.View.RetroView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.markpadua.philippineplaces.Model.places
import com.example.markpadua.philippineplaces.R
import com.example.markpadua.philippineplaces.Contract.RetroContract.IListListener

class placeAdapter(private val places : List<places>, val listener: IListListener) :  RecyclerView.Adapter<placeHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): placeHolder {
        val itemview = LayoutInflater.from(p0.context).inflate(R.layout.list_layout,p0,false)
        return placeHolder(itemview)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(p0: placeHolder, p1: Int) {
        p0.BindData(places,p1,listener)
    }

}
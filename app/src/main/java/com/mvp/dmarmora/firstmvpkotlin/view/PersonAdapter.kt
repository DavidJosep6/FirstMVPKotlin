package com.mvp.dmarmora.firstmvpkotlin.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvp.dmarmora.firstmvpkotlin.R
import com.mvp.dmarmora.firstmvpkotlin.model.database.PersonEntity
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter(val personsList: List<PersonEntity>, val context: Context) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.person_item, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.tvName?.text = personsList.get(p1).name
        p0.tvLocation?.text = personsList.get(p1).location
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.tv_name
        val tvLocation = view.tv_location
    }

}

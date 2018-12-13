package com.example.sunil.dhun

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HomeActivityRecyclerViewAdapter(val context:Context, val data:ArrayList<SectionModel>):
    RecyclerView.Adapter<HomeActivityRecyclerViewAdapter.SectionViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SectionViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: SectionViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener {
        override fun onClick(v: View?) {

        }

        fun bindItem(data:SectionModel){
           val title = itemView.findViewById<TextView>(R.id.title_tv)
           val more = itemView.findViewById<TextView>(R.id.more_tv)
           val horizontalRecyclerView = itemView.findViewById<RecyclerView>(R.id.section_horizontal_rv)
            title.text = data.title
            more.setOnClickListener(this)
            horizontalRecyclerView.

        }

    }
}
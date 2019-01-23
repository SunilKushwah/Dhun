package com.example.sunil.dhun

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.sunil.dhun.data.Song

class HomeActivityRecyclerViewAdapter(val context:Context, val data:ArrayList<SectionModel>):
    RecyclerView.Adapter<HomeActivityRecyclerViewAdapter.SectionViewHolder>(){
    lateinit var clickListener: OnClickLenderListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.section_layout,parent,false)
        return SectionViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bindItem(data[position])
    }

    fun setOnClickListener(clickListener: OnClickLenderListener){
        this.clickListener = clickListener
    }

    fun setData(refreshedData: ArrayList<SectionModel>) {
        data.clear()
        data.addAll(refreshedData)
        notifyDataSetChanged()
    }


    inner class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener,
        SectionRecyclerViewAdapter.OnClickLenderListener {
        override fun onClick(position: Int) {
            clickListener.onClickSectionItem(adapterPosition,position)
        }

        override fun onClick(v: View?) {
            clickListener.onClickSectionMore(adapterPosition)
        }

        fun bindItem(data:SectionModel){
           val title = itemView.findViewById<TextView>(R.id.title_tv)
           val more = itemView.findViewById<TextView>(R.id.more_tv)
           val horizontalRecyclerView = itemView.findViewById<RecyclerView>(R.id.section_horizontal_rv)
            title.text = data.title
           val adapter = SectionRecyclerViewAdapter(context,data.items)
            horizontalRecyclerView.setHasFixedSize(true)
            horizontalRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            horizontalRecyclerView.adapter = adapter
            adapter.setOnClickListener(this)
            more.setOnClickListener(this)
        }

    }

    interface OnClickLenderListener {
        fun onClickSectionMore(section: Int)
        fun onClickSectionItem(section: Int, position: Int)
    }
}
package com.example.sunil.dhun

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class SectionRecyclerViewAdapter(val context: Context, val data:ArrayList<SectionItemModel>):
    RecyclerView.Adapter<SectionRecyclerViewAdapter.SectionListItemViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SectionListItemViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: SectionListItemViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class SectionListItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
         override fun onClick(v: View?) {
             TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         }

        fun bindItem(item:SectionItemModel){
            val itemImage = itemView.findViewById<ImageView>(R.id.item_iv)
            val itemTitle = itemView.findViewById<TextView>(R.id.title_tv)
            val itemCardView = itemView.findViewById<CardView>(R.id.section_item_cv)
            itemImage.setImageResource(item.url)
            itemTitle.text=item.name
            itemCardView.setOnClickListener(this)
        }

     }
}
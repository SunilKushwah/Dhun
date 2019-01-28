package com.example.sunil.dhun

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class SectionRecyclerViewAdapter(val context: Context, val data:ArrayList<SectionItemModel>):
    RecyclerView.Adapter<SectionRecyclerViewAdapter.SectionListItemViewHolder>() {

    lateinit var clickListener: OnClickLenderListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.section_list_item_layout,parent,false)
        return SectionListItemViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SectionListItemViewHolder, position: Int) {
        holder.bindItem(data[position])
    }
    fun setOnClickListener(clickListener: OnClickLenderListener){
        this.clickListener = clickListener
    }


    inner class SectionListItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
         override fun onClick(v: View?) {
             clickListener.onClick(adapterPosition)
         }

        fun bindItem(item:SectionItemModel){
            val itemImage = itemView.findViewById<ImageView>(R.id.item_iv)
            val itemTitle = itemView.findViewById<TextView>(R.id.title_tv)
            val itemCardView = itemView.findViewById<CardView>(R.id.section_item_cv)
            itemTitle.text=item.song
            Glide.with(itemView.context)
                .load(item.url)
                .into(itemImage)
            itemCardView.setOnClickListener(this)
        }

     }
    interface OnClickLenderListener {
        fun onClick(position: Int)
    }
}
package com.gdk.rio.footballclublist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ClubAdapter (private val context: Context, private val clubItem: List<ClubItem>, private val listener: (ClubItem)-> Unit)
    : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>(){
    class ClubViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val clubName = view.findViewById<TextView>(R.id.tv_clubname)
        private val clubLogo = view.findViewById<ImageView>(R.id.iv_clublogo)

        fun bindClubItem (clubItems: ClubItem, listener: (ClubItem) -> Unit){
            clubName.text = clubItems.name
            Glide.with(itemView.context).load(clubItems.logo).into(clubLogo)
            itemView.setOnClickListener { listener(clubItems) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder{
        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.club_list, parent, false))
    }

    override fun getItemCount(): Int {
        return clubItem.size
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindClubItem(clubItem[position], listener)
    }
}

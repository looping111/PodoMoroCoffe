package com.example.podomorocoffe.Home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.podomorocoffe.R
import com.squareup.picasso.Picasso

class NewsHorizontalAdapter (
    private val mList: List<NewsHorizontalModel>,
) : RecyclerView.Adapter<NewsHorizontalAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_horizontal_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.newsTitle.text = item.newsTitle
        Picasso.get().load(item.imageUrl).into(holder.newsImage)
        holder.itemView.setOnClickListener {
            Log.i("RecyclerView", "Click ke $position: ${item.newsTitle}")
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val newsImage: ImageView = itemView.findViewById(R.id.newHoriImage)
        val newsTitle: TextView = itemView.findViewById(R.id.newsHoriTitle)
    }
}
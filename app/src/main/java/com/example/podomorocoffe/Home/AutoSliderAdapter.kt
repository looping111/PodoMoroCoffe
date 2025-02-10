package com.example.podomorocoffe.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.podomorocoffe.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AutoSliderAdapter (

    private val images: List<Int>,
    private val viewPager: ViewPager2
) : RecyclerView.Adapter<AutoSliderAdapter.SliderViewHolder>() {
    private var currentPosition = 0

    init {
        startAutoSlide()
    }

    class SliderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageSlider)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slide_item, parent, false)
        return SliderViewHolder(view)
    }
    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val itemUrl = images[position]
        Picasso.get().load(itemUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    //    digunakan untuk start auto slide
    private fun startAutoSlide() {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                delay(3000)
                currentPosition = (currentPosition + 1) %itemCount
                viewPager.setCurrentItem(currentPosition, true)
            }
        }
    }
}
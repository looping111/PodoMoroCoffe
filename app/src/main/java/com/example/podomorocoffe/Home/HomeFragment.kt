package com.example.podomorocoffe.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.podomorocoffe.R
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setupAutoSlider(view)
        return view
    }

    private fun setupAutoSlider (view: View) {
        val images = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.autoSlider)
        val dotsIndicator: WormDotsIndicator = view.findViewById(R.id.worm_indicator)

        viewPager.adapter = AutoSliderAdapter(images, viewPager)
        dotsIndicator.attachTo(viewPager)
    }
}
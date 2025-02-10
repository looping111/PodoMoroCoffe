package com.example.podomorocoffe.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.podomorocoffe.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OrderFragment : Fragment() {

    companion object {
        private val TAB_TITLES = intArrayOf(
            R.string.outlet,
            R.string.p_voucher,
            R.string.b_card
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }
        override fun onViewCreated(view: View, savedInstanceState:
        Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val orderAdapater = OrderAdapater(this)
            val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)
            viewPager.adapter = orderAdapater
            val tabs: TabLayout = view.findViewById(R.id.tabs)
            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
            (requireActivity() as AppCompatActivity).supportActionBar?.elevation = 0f
    }
}
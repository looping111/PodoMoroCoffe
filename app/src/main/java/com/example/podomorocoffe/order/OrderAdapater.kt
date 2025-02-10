package com.example.podomorocoffe.order

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OrderAdapater(fragment: Fragment) :
        FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->  OutletFragment()
            1 ->  BCardFragment()
            2 ->  PVoucherFragment()
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
    override fun getItemCount(): Int {
        return 3
    }
}

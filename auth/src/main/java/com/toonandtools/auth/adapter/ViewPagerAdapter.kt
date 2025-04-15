package com.toonandtools.auth.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.toonandtools.auth.EmailLoginFragment
import com.toonandtools.auth.LoginFragment
import com.toonandtools.auth.PhoneLoginFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EmailLoginFragment()
            else -> PhoneLoginFragment()
        }
    }
}

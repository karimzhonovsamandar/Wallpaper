package com.sammy.wallpaper.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sammy.wallpaper.fragments.AllFragment
import com.sammy.wallpaper.fragments.AnimalsFragment
import com.sammy.wallpaper.fragments.NaturalFragment
import com.sammy.wallpaper.fragments.NewFragment
import com.sammy.wallpaper.fragments.TachnologyFragment
import com.sammy.wallpaper.model.User

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val data: ArrayList<User>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> AllFragment()
            1 -> NewFragment()
            2 -> AnimalsFragment()
            3 -> TachnologyFragment()
            4 -> NaturalFragment()
            else ->  AllFragment()
        }
    }
}

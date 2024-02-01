package com.sammy.wallpaper.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sammy.wallpaper.R
import com.sammy.wallpaper.adapter.RvImageAdapter
import com.sammy.wallpaper.databinding.FragmentHomeBinding
import com.sammy.wallpaper.adapter.ViewPagerAdapter
import com.sammy.wallpaper.databinding.TabItemBinding
import com.sammy.wallpaper.model.User

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    var categoryList: ArrayList<User> = ArrayList()
    private lateinit var recyclerViewAdapter: RvImageAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        categoryList.add(User("ALL"))
        categoryList.add(User("NEW"))
        categoryList.add(User("ALIMALS"))
        categoryList.add(User("TECHNOLOGY"))
        categoryList.add(User("NATURE"))

        binding.viewPager.adapter = ViewPagerAdapter(requireActivity(),categoryList)


        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            val customTabViewBinding = TabItemBinding.inflate(layoutInflater)

            if (position == 0){
                customTabViewBinding.tabIndic.visibility = View.VISIBLE
            }else{
                customTabViewBinding.tabIndic.visibility = View.GONE
            }

            customTabViewBinding.txtTitle.text = categoryList[position].title

            tab.customView = customTabViewBinding.root
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.view?.findViewById<LinearLayout>(R.id.tab_indic)
                    ?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.view?.findViewById<LinearLayout>(R.id.tab_indic)
                    ?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        return binding.root
    }

}


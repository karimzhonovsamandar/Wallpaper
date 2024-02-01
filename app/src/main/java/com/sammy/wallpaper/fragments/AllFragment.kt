package com.sammy.wallpaper.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sammy.wallpaper.GetImageActivity
import com.sammy.wallpaper.R
import com.sammy.wallpaper.databinding.FragmentAllBinding
import com.sammy.wallpaper.adapter.RvImageAdapter

class AllFragment : Fragment() {

    private lateinit var binding: FragmentAllBinding
    private lateinit var rvImageAdapter: RvImageAdapter
    private lateinit var list: ArrayList<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllBinding.inflate(inflater, container, false)
        data()
        rvImageAdapter = RvImageAdapter(list, object : RvImageAdapter.RvClick{
            override fun onClick(image: Int) {
                val intent = Intent(requireContext(), GetImageActivity::class.java)

                intent.putExtra("selectedImage", image)

                startActivity(intent)
            }
        })

        binding.rv.adapter = rvImageAdapter
        Log.d("onCreateView", "Oncreate")
        return binding.root

    }

    private fun data() {

        list = ArrayList()
        for (i in 0..10){
            list.add(R.drawable.photo1)
            list.add(R.drawable.photo2)
            list.add(R.drawable.photo3)
            list.add(R.drawable.photo4)
            list.add(R.drawable.photo5)
        }

    }

}
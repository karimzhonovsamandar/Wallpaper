package com.sammy.wallpaper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammy.wallpaper.databinding.ItemRvBinding


class RvImageAdapter(val imageList:ArrayList<Int>,val rvklick:RvClick) : RecyclerView.Adapter<RvImageAdapter.Vh>() {

    inner class Vh(var itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBind(image: Int, position: Int) {
            itemRvBinding.itemRvImageView.setImageResource(image)

            itemRvBinding.root.setOnClickListener {
                rvklick.onClick(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(imageList[position], position)

    }

    interface RvClick {
        fun onClick(image: Int)
    }

}
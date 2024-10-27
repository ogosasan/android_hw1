package com.example.vk_hw1

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    private val items = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (items[position] % 2 == 0) {
            val col = ColorDrawable(0xFFFF6666.toInt())
            holder.bind(items[position], col)
        }else{
            val col = ColorDrawable(0xFF1100ff.toInt())
            holder.bind(items[position], col)
        }
    }

    fun setItems(list: List<Int>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(item: Int) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun getItems(): ArrayList<Int> {
        return items
    }
}
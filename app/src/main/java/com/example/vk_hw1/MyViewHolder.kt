package com.example.vk_hw1

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val text = view.findViewById<TextView>(R.id.text_1)
    val image = view.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int, color: Drawable){
        text.text = "$number"
        image.background = color
    }
}

package com.example.bms_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class CategoryAdapter(val activity : ProductsActivity, val list : ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    class CategoryViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val categoryTitle = v.findViewById<TextView>(R.id.categoryTitle)
        val categoryImg = v.findViewById<ImageView>(R.id.cateogtyImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(activity).inflate(R.layout.category_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        if (position < list.size){
            val category = list[position]

            holder.categoryTitle.text = category.title
            holder.categoryImg.setImageResource(category.imgSrc)

        }
    }
}
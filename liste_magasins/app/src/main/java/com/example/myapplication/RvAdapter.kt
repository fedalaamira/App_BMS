package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by Fedala Amira.
 */
class RvAdapter(val userList: ArrayList<Model>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    val itemImages = arrayOf(R.drawable.un,R.drawable.deux,R.drawable.first,R.drawable.first)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_item_layout, p0, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.name?.text = userList[p1].name
        p0.name2?.text = userList[p1].name2
        p0.map?.text = userList[p1].map
        p0.count?.setImageResource(itemImages[p1])

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val name2 = itemView.findViewById<TextView>(R.id.tvName2)
        val count = itemView.findViewById<ImageView>(R.id.tvCount)
        val map = itemView.findViewById<TextView>(R.id.map)

    }
}
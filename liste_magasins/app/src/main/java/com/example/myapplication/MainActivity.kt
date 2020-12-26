package com.example.myapplication
import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model
class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL, false)
        val dataList = ArrayList<Model>()
        dataList.add(Model("Vapstore","grossiste","Map",1))
        dataList.add(Model("Vapstore","grossiste" ,"Map",2))
        dataList.add(Model("Vapstore","grossiste","Map", 3))
        dataList.add(Model("Vapstore","grossiste","Map", 4))
        val rvAdapter = RvAdapter(dataList)
        recyclerView.adapter = rvAdapter
    }
}

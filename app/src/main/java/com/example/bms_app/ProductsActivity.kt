package com.example.bms_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : AppCompatActivity() {

    var categoriesList = arrayListOf<Category>()

    lateinit var categoryAdapter: CategoryAdapter
    lateinit var categoriesLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        categoriesLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recycleCategories = findViewById<RecyclerView>(R.id.RecyclerCategories)

        recycleCategories.layoutManager = categoriesLayoutManager

        categoryAdapter = CategoryAdapter(this, categoriesList)
        recycleCategories.adapter = categoryAdapter
        initCategories()
        categoryAdapter.notifyDataSetChanged()
    }

    fun initCategories(){
        val cat0 = Category(0, R.drawable.icon_add, "Ajouter")
        val cat1 = Category(1, R.drawable.disjoncteur, "Disjnoncteur")
        val cat2 = Category(2, R.drawable.interrupteur, "Interrupteur")
        val cat3 = Category(3, R.drawable.lampe, "Lampe")
        val cat4 = Category(4, R.drawable.multiprise, "Multiprise")

        categoriesList.add(cat0)
        categoriesList.add(cat1)
        categoriesList.add(cat2)
        categoriesList.add(cat3)
        categoriesList.add(cat4)

    }
}
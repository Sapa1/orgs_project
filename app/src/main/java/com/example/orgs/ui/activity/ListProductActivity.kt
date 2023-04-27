package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.ui.recyclerview.adapter.ListProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListProductActivity : AppCompatActivity(R.layout.activity_list_product) {
    private val dao = ProductsDao()
    private val adapter = ListProductAdapter(
        context = this, products = dao.searchAll()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.refresh(dao.searchAll())

    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_list_product_fab)
        fab.setOnClickListener {
            goToProductForm()
        }
    }

    private fun goToProductForm() {
        val intent = Intent(
            this, FormProductActivity::class.java
        )
        startActivity(intent)
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_list_product_recyclerView)

        recyclerView.adapter = adapter
    }
}
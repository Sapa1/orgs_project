package com.example.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Product
import com.example.orgs.ui.recyclerview.adapter.ListProductAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val title = findViewById<TextView>(R.id.titleCest)
//        title.text = "Cesta de frutas"
//        val description = findViewById<TextView>(R.id.descriptionCest)
//        description.text = "Laranja, manga e uva"
//        val cost = findViewById<TextView>(R.id.costItemCest)
//        cost.text = "R$ 19.99"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListProductAdapter(
            context = this, products = listOf(
                Product(
                    name = "teste",
                    description = "teste desc",
                    cost = BigDecimal("19.99")
                ),
                Product(
                    name = "teste2",
                    description = "teste desc2",
                    cost = BigDecimal("29.99")
                ),
                Product(
                    name = "teste3",
                    description = "teste desc3",
                    cost = BigDecimal("39.99")
                ),
            )
        )
//        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
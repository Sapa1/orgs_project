package com.example.orgs.dao

import com.example.orgs.model.Product
import java.math.BigDecimal

class ProductsDao {

    fun add(product: Product) {
        products.add(product)
    }

    fun searchAll(): List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>(
            Product(
                name = "Banana",
                description = "Um monte de bananas",
                cost = BigDecimal("19.99"),
            )
        )
    }
}
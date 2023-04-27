package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity :
    AppCompatActivity(R.layout.activity_form_product) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configSaveButton()
    }

    private fun configSaveButton() {
        val saveButton = findViewById<Button>(R.id.activity_form_product_button)
        val dao = ProductsDao()
        saveButton.setOnClickListener {
            val newProduct = createProduct()

            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val fieldTitleForm = findViewById<EditText>(R.id.activity_form_product_name)
        val titleForm = fieldTitleForm.text.toString()
        val fieldDescriptionForm = findViewById<EditText>(R.id.activity_form_product_description)
        val descriptionForm = fieldDescriptionForm.text.toString()
        val fieldCostForm = findViewById<EditText>(R.id.activity_form_product_value)
        val costForm = fieldCostForm.text.toString()
        val value = if (costForm.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(costForm)
        }

        return Product(
            name = titleForm,
            description = descriptionForm,
            cost = value,
        )
    }
}


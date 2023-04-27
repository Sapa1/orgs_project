package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
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
        val saveButton = findViewById<Button>(R.id.buttonForm)
        saveButton.setOnClickListener {
            val fieldTitleForm = findViewById<EditText>(R.id.titleForm)
            val titleForm = fieldTitleForm.text.toString()
            val fieldDescriptionForm = findViewById<EditText>(R.id.descriptionForm)
            val descriptionForm = fieldDescriptionForm.text.toString()
            val fieldCostForm = findViewById<EditText>(R.id.costForm)
            val costForm = fieldCostForm.text.toString()
            val value = if (costForm.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(costForm)
            }
            val newProduct = Product(
                name = titleForm,
                description = descriptionForm,
                cost = value,
            )

            Log.i("FormProductActivity", "onCreate: $newProduct")
            val dao = ProductsDao()
            dao.add(newProduct)
            Log.i("FormProductActivity", "onCreate: ${dao.searchAll()}")
            finish()
        }
    }
}


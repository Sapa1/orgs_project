package com.example.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Product

class ListProductAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val title = itemView.findViewById<TextView>(R.id.titleCest)
            title.text = product.name
            val description = itemView.findViewById<TextView>(R.id.descriptionCest)
            description.text = product.description
            val cost = itemView.findViewById<TextView>(R.id.costItemCest)
            cost.text = product.cost.toPlainString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)

    }

    override fun getItemCount(): Int = products.size

}

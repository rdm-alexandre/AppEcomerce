package com.example.appecomercemarkepro.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.animation.core.animateDecay
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appecomercemarkepro.R
import com.example.appecomercemarkepro.data.model.Product
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
{
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val ivProduct: ImageView = view.findViewById(R.id.ivProduct)
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
        val txtDesc: TextView = view.findViewById(R.id.txtDesc)
        val txtValue: TextView = view.findViewById(R.id.txtValue)
        val txtNumberOfStars: TextView = view.findViewById(R.id.txtNumberOfStars)
        val txtDescValue: TextView = view.findViewById(R.id.txtDescValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int)
    {
        val product = products[position]
        holder.ivProduct.setImageResource(android.R.drawable.ic_menu_gallery)
        holder.txtTitle.text = product.brand
        holder.txtDesc.text = product.title
        holder.txtValue.text = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(product.price)
        holder.txtDescValue.text = product.descriptionValue
    }

    override fun getItemCount(): Int = products.size
}
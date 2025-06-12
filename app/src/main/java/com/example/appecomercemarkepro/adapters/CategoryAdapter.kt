package com.example.appecomercemarkepro.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.appecomercemarkepro.R
import com.example.appecomercemarkepro.data.model.Category
import com.example.appecomercemarkepro.data.model.SliderImage

class CategoryAdapter(
    private val categories: List<Category>,
    private val imageList: List<SliderImage>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_BANNER = 0
        private const val TYPE_CATEGORY = 1
    }

    // ViewHolder para o banner
    class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewPager: ViewPager2 = view.findViewById(R.id.viewPager2)

        fun bind(images: List<SliderImage>) {
            val adapter = ImageAdapter()
            viewPager.adapter = adapter
            adapter.submitList(images)
        }
    }

    // ViewHolder para a categoria
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCategoryName: TextView? = view.findViewById(R.id.tvCategoryName)
        val rvProductCategory: RecyclerView = view.findViewById(R.id.rvProductCategory)
    }

    override fun getItemCount(): Int = categories.size + 1 // +1 para o banner

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_BANNER else TYPE_CATEGORY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_BANNER) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
            BannerViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category_section, parent, false)
            CategoryViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BannerViewHolder) {
            holder.bind(imageList)
        } else if (holder is CategoryViewHolder) {
            val category = categories[position - 1] // -1 porque o primeiro item é o banner
            holder.tvCategoryName?.text = category.name

            holder.rvProductCategory.layoutManager = LinearLayoutManager(
                holder.itemView.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            holder.rvProductCategory.adapter = ProductAdapter(category.products)
        }
    }
}

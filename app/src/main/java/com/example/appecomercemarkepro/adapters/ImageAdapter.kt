package com.example.appecomercemarkepro.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appecomercemarkepro.R
import com.example.appecomercemarkepro.data.model.SliderImage

class ImageAdapter : ListAdapter<SliderImage, ImageAdapter.ViewHolder>(DiffCallback())
{
    class DiffCallback : DiffUtil.ItemCallback<SliderImage>()
    {
        override fun areItemsTheSame(oldItem: SliderImage, newItem: SliderImage): Boolean {
            return oldItem.id === newItem.id
        }

        override fun areContentsTheSame(oldItem: SliderImage, newItem: SliderImage): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(sliderImageModel: SliderImage) {
            Glide.with(itemView)
                .load(sliderImageModel.url)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.image_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageItem = getItem(position)
        holder.bind(imageItem)
    }
}
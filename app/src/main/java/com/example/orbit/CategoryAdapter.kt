package com.example.orbit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val categories: List<Category>,
    private val onCategoryClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewIcon: ImageView = itemView.findViewById(R.id.imageViewIcon)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.textViewName.text = category.name
        holder.imageViewIcon.setImageResource(category.icon)
        
        // Animation
        holder.itemView.alpha = 0f
        holder.itemView.animate().alpha(1f).setDuration(500).setStartDelay(position * 100L).start()

        holder.itemView.setOnClickListener { onCategoryClick(category) }
    }

    override fun getItemCount(): Int = categories.size
}
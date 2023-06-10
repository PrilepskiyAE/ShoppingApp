package com.prilepskiy.sdk.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.ItemCategoryNameBinding

class CategoryAdapter(private val onClickButtonClicked: (category: com.prilepskiy.core.domain.model.CategoryModel) -> Unit) :
    ListAdapter<com.prilepskiy.core.domain.model.CategoryModel, CategoryAdapter.CategoryHolder>(Comporator()) {


    class CategoryHolder(
        view: View,
        private val onClickButtonClicked: (category: com.prilepskiy.core.domain.model.CategoryModel) -> Unit
    ) : RecyclerView.ViewHolder(view)
    {
        private val binding = ItemCategoryNameBinding.bind(view)



        fun bind(categoryModel: com.prilepskiy.core.domain.model.CategoryModel) = with(binding) {
            // Log.d("TAG999", "bind: ${categoryModel.image_url}")
            Glide.with(itemView)
                .load(categoryModel.image_url).into(binding.imLogo)
            tvName.text = categoryModel.name
            imLogo.setOnClickListener {
                onClickButtonClicked(categoryModel)
            }

        }

    }

    class Comporator : DiffUtil.ItemCallback<com.prilepskiy.core.domain.model.CategoryModel>() {
        override fun areItemsTheSame(oldItem: com.prilepskiy.core.domain.model.CategoryModel, newItem: com.prilepskiy.core.domain.model.CategoryModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: com.prilepskiy.core.domain.model.CategoryModel, newItem: com.prilepskiy.core.domain.model.CategoryModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_name, parent, false)

        return CategoryHolder(view = view, onClickButtonClicked)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
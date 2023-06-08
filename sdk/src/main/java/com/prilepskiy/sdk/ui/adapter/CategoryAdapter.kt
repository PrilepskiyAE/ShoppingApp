package com.prilepskiy.sdk.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prilepskiy.domain.model.CategoryModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.ItemCategoryNameBinding

class CategoryAdapter(private val onClickButtonClicked: (category: CategoryModel) -> Unit) :
    ListAdapter<CategoryModel, CategoryAdapter.CategoryHolder>(Comporator()) {


    class CategoryHolder(
        view: View,
        private val onClickButtonClicked: (category: CategoryModel) -> Unit
    ) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private val binding = ItemCategoryNameBinding.bind(view)
        private var tempCategoryModel: CategoryModel? = null


        fun bind(categoryModel: CategoryModel) = with(binding) {
            tempCategoryModel = categoryModel
            // Log.d("TAG999", "bind: ${categoryModel.image_url}")
            Glide.with(itemView)
                .load(categoryModel.image_url).into(binding.imLogo)
            tvName.text = categoryModel.name
            imLogo.setOnClickListener {
                onClickButtonClicked(categoryModel)
            }

        }

        override fun onClick(p0: View?) {

        }
    }

    class Comporator : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
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
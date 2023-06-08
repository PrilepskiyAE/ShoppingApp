package com.prilepskiy.sdk.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.ItemDisheBinding
import com.prilepskiy.sdk.databinding.ItemTagsBinding
import com.prilepskiy.sdk.ui.model.TagUiModel

class TagAdapter(private val onClickButtonClicked: (tag: TagUiModel) -> Unit,) :ListAdapter<TagUiModel, TagAdapter.TagHolder>(TagAdapter.Comporator()) {

    class TagHolder(
        view: View,
        private val onClickButtonClicked: (tag: TagUiModel) -> Unit,

        ) : RecyclerView.ViewHolder(view)
    { private val binding = ItemTagsBinding.bind(view)
        fun bind(tag: TagUiModel)  {
            with(binding){

                }
            }
        }



    class Comporator : DiffUtil.ItemCallback<TagUiModel>(){
        override fun areItemsTheSame(oldItem: TagUiModel, newItem: TagUiModel): Boolean {
            return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: TagUiModel, newItem: TagUiModel): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {
        val view= LayoutInflater.from(parent.context)
        .inflate(R.layout.item_tags, parent, false)
        return TagHolder(view,onClickButtonClicked )
    }

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
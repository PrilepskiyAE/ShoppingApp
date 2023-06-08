package com.prilepskiy.sdk.ui.adapter

import android.annotation.SuppressLint
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


class DisheAdapter(private val onClickButtonClicked: (dishe: DisheModel) -> Unit,) : ListAdapter<DisheModel, DisheAdapter.DisheHolder>(DisheAdapter.Comporator()){
    class DisheHolder(
        view: View,
        private val onClickButtonClicked: (dishe: DisheModel) -> Unit,

    ) : RecyclerView.ViewHolder(view)
    { private val binding = ItemDisheBinding.bind(view)
        fun bind(disheModel: DisheModel)  {
            with(binding){
                Glide.with(itemView)
                    .load(disheModel.image_url).into(binding.imgDishe)
                tvName.text = disheModel.name
                imgDishe.setOnClickListener {
                    onClickButtonClicked(disheModel)
                }
            }
        }

        }

    class Comporator : DiffUtil.ItemCallback<DisheModel>() {
        override fun areItemsTheSame(oldItem: DisheModel, newItem: DisheModel): Boolean =oldItem.id==newItem.id

        override fun areContentsTheSame(oldItem: DisheModel, newItem: DisheModel): Boolean {
            return oldItem.equals(newItem)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):DisheHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dishe, parent, false)
        return DisheHolder(view,onClickButtonClicked)
    }

    override fun onBindViewHolder(holder: DisheHolder, position: Int) {
        holder.bind(getItem(position))
    }


}






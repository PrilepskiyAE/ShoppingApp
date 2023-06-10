package com.prilepskiy.sdk.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.model.DisheModel
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.ItemBasketBinding
import com.prilepskiy.sdk.databinding.ItemDisheBinding

class BasketAdapter(
    private val onClickButtonPositive: (basket: com.prilepskiy.core.domain.model.BasketModel) -> Unit,
    private val onClickButtonNigative: (basket: com.prilepskiy.core.domain.model.BasketModel) -> Unit
) :
    ListAdapter<com.prilepskiy.core.domain.model.BasketModel, BasketAdapter.BasketHolder>(Comporator()) {
    class Comporator : DiffUtil.ItemCallback<com.prilepskiy.core.domain.model.BasketModel>() {
        override fun areItemsTheSame(oldItem: com.prilepskiy.core.domain.model.BasketModel, newItem: com.prilepskiy.core.domain.model.BasketModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: com.prilepskiy.core.domain.model.BasketModel, newItem: com.prilepskiy.core.domain.model.BasketModel): Boolean {
            return oldItem.equals(newItem)
        }


    }

    inner class BasketHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        private val binding = ItemBasketBinding.bind(view)
        fun bind(basket: com.prilepskiy.core.domain.model.BasketModel) {
            with(binding) {
                Glide.with(itemView)
                    .load(basket.image_url)
                    .into(imgDishe)
                tvTitle.text = basket.name
                tvPrice.text = basket.price.toString()
                tvWeight.text = basket.weight.toString()
                textView.text = basket.colum.toString()
                binding.imageView2.setOnClickListener { onClickButtonNigative(basket) }
                binding.imageView3.setOnClickListener { onClickButtonPositive(basket) }
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basket, parent, false)
        return BasketHolder(view)
    }

    override fun onBindViewHolder(holder: BasketHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
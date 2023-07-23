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
    private val onClickButtonPositive: (basket: BasketModel,count:Int) -> Unit,
    private val onClickButtonNigative: (basket: BasketModel,count:Int) -> Unit
) :
    ListAdapter<BasketModel, BasketAdapter.BasketHolder>(Comporator()) {
    class Comporator : DiffUtil.ItemCallback<BasketModel>() {

        override fun areItemsTheSame(oldItem: BasketModel, newItem: BasketModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: BasketModel, newItem: BasketModel): Boolean {
            return oldItem.equals(newItem)
        }


    }

    inner class BasketHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        private val binding = ItemBasketBinding.bind(view)
        fun bind(basket: BasketModel) {
            with(binding) {

               var count= basket.colum
                Glide.with(itemView)
                    .load(basket.image_url)
                    .into(imgDishe)
                tvTitle.text = basket.name
                val priceFormat=(basket.price).toString()+"₽"
                tvPrice.text = priceFormat
                val weightFormat=(basket.weight).toString()+"Г"
                tvWeight.text = weightFormat
                tvColum.text = basket.colum.toString()

                btNigotive.setOnClickListener {
                   // onClickButtonNigative(basket)
                    tvColum.text = (--count).toString()

                }
                btPositive.setOnClickListener {
                    //onClickButtonPositive(basket)
                    tvColum.text = (++count).toString()

                }
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
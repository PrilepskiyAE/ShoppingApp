package com.prilepskiy.sdk.ui.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.ItemTagsBinding
import com.prilepskiy.domain.model.TagModel

class TagAdapter(private val onClickButtonClicked: (tag: TagModel) -> Unit) :ListAdapter<TagModel, TagAdapter.TagHolder>(TagAdapter.Comporator()) {
    //var t="ВСЕ МЕНЮ"

   inner class TagHolder(
        view: View,
        ) : RecyclerView.ViewHolder(view)
    {
        private val binding = ItemTagsBinding.bind(view)
        fun bind(tag: TagModel)  {
            Log.d("TAG9999", "bind:${tag.isActive} ")
            with(binding){
               // if (t==tag.name){button.setBackgroundColor(Color.BLUE)}

                button.text=tag.name
                button.setOnClickListener {
                  //  if (t==tag.name){button.setBackgroundColor(Color.BLUE)}else button.setBackgroundColor(Color.WHITE)
                   // t=tag.name


                    onClickButtonClicked(tag)

                }
                }
            }


        }



    class Comporator : DiffUtil.ItemCallback<TagModel>(){
        override fun areItemsTheSame(oldItem: TagModel, newItem: TagModel): Boolean {
            return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: TagModel, newItem: TagModel): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {

        val view=  when(viewType){
            TAG_ACTIVE->LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tags, parent, false)
            TAG_PASSIVE->LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tags_active, parent, false)

            else -> {throw RuntimeException("Unknown view type: $viewType")}}

        return TagHolder(view)
    }

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
            holder.bind(getItem(position))

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.isActive){
            TAG_ACTIVE
        }else{
           TAG_PASSIVE
        }
    }


    companion object{
        const val TAG_PASSIVE=200
        const val TAG_ACTIVE=201

    }
}
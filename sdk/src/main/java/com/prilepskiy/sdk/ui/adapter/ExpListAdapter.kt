package com.prilepskiy.sdk.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.core.content.ContextCompat
import com.prilepskiy.sdk.R
import com.prilepskiy.sdk.databinding.ItemBasketBinding
import com.prilepskiy.sdk.databinding.ItemHelpChildViewBinding
import com.prilepskiy.sdk.databinding.ItemHelpGroupViewBinding

class ExpListAdapter(
    private val applicationContext: Context,
    private val groups: List<Pair<String, ArrayList<String>>>
) : BaseExpandableListAdapter()
{


    override fun getGroupCount(): Int {
        return groups.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return groups[groupPosition].second.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return groups[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return groups[groupPosition].second[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }


    override fun getGroupView(
        groupPosition: Int, isExpanded: Boolean, view: View?,
        parent: ViewGroup?
    ): View {

        val binding =
            ItemHelpGroupViewBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        with(binding) {

            if (isExpanded) {
                imVetorHelp.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.baseline_keyboard_arrow_down_24
                    )
                )

            } else {
                imVetorHelp.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.baseline_chevron_right_24
                    )
                )


            }
            textGroup.text = groups[groupPosition].first
        }

        return binding.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val binding =
            ItemBasketBinding.inflate(LayoutInflater.from(parent?.context), parent, false)


        binding.tvTitle.text = groups[groupPosition].second[childPosition]
        binding.cardView4.visibility=View.GONE


        return binding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}
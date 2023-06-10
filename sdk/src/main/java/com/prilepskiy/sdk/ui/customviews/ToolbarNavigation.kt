package com.prilepskiy.sdk.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.prilepskiy.sdk.databinding.ToolbarNavigationBinding
import com.prilepskiy.sdk.databinding.ToolbarStandardBinding

class ToolbarNavigation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, ): ConstraintLayout(context, attrs) {
    private lateinit var binding: ToolbarNavigationBinding


    init {
        createToolbar()
    }

    private fun createToolbar() {
        binding = ToolbarNavigationBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
    }

    fun setTitleText(text: String) {
        binding.tvTitle.text=text
    }

    fun onClick(onClickButtonClicked: () -> Unit){
        binding.btDown.setOnClickListener {  onClickButtonClicked()}
    }

}
package com.prilepskiy.sdk.ui.customviews

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.constraintlayout.widget.ConstraintLayout
import com.prilepskiy.sdk.databinding.ToolbarStandardBinding

class ToolbarStandard@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, ): ConstraintLayout(context, attrs) {
    private lateinit var binding: ToolbarStandardBinding


    init {
        createToolbar()
    }

    private fun createToolbar() {
        binding = ToolbarStandardBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
    }

    fun setTitleText(text: String) {
        binding.tvTitle.text=text
    }

}
package com.prilepskiy.sdk.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.prilepskiy.domain.model.CategoryModel
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.sdk.databinding.ShoppingBasketDialogBinding

object DialogManager {
    fun showShoppingBasketDialog(context: Context, onClickButtonClicked: () -> Unit,disheModel:DisheModel){
        Log.d("DishesFragment", "showShoppingBasketDialog: ")
        val builder= AlertDialog.Builder(context)
        val binding=ShoppingBasketDialogBinding.inflate(LayoutInflater.from(context),null,false)
        builder.setView(binding.root)
        val dialog=builder.create()
        binding.apply {
            Glide.with(imgDishe)
                .load(
                    if (disheModel.image_url.isNullOrEmpty())
                        disheModel.description
                    else
                        disheModel.image_url
                ).into(imgDishe)
            tvTitle.text=disheModel.name
            val formatPrice= "${disheModel.price} ₽"
            tvPrice.text=formatPrice
            val formatWeight="${disheModel.weight} Г"
            tvWeight.text=formatWeight
            tvDescription.text=disheModel.description
            binding.btAdd.setOnClickListener {
                dialog.dismiss()
            }
            binding.btCloce.setOnClickListener {
                dialog.dismiss()
            }

        }

        dialog.show()
    }

    fun showTestDialog(context: Context){
        val builder=AlertDialog.Builder(context)
        val dialog=builder.create()
        dialog.setTitle("")
        dialog.setMessage("")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"Yes"){
                _,_->

        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){
                _,_-> dialog.dismiss()
        }

        dialog.show()
    }

}
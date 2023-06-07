package com.prilepskiy.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prilepskiy.sdk.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(
            R.id.container,
            MainFragment()
        )
        transaction.commit()

    }
}
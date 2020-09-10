package com.tcc.assignment.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(supportActionBar == null) {
            setSupportActionBar(toolbar)
        }

    }



}

package com.tcc.assignment.ui.module

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcc.assignment.R
import com.tcc.assignment.base.BaseActivity
import com.tcc.assignment.databinding.ActivityRoutesBinding
import com.tcc.assignment.model.api.StopModel
import com.tcc.assignment.ui.adapter.RoutesAdapter
import com.tcc.assignment.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.app_bar_main.view.*


class RouteActivity : BaseActivity() {

    private lateinit var binding: ActivityRoutesBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_routes)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setSupportActionBar(binding.appBar.toolbar)
        setupView()
        initviewModel()

    }

    fun setupView() {
        val data = intent.getParcelableExtra<StopModel>("routeData")
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.routesRV.layoutManager = linearLayoutManager


        supportActionBar!!.title = data?.name
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val adapter = RoutesAdapter(this, data?.routes!!)
        binding.routesRV.adapter = adapter


    }

    fun initviewModel() {


    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }


}
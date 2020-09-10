package com.tcc.assignment.ui.module

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcc.assignment.R
import com.tcc.assignment.base.BaseActivity
import com.tcc.assignment.databinding.ActivityRouteDetailBinding
import com.tcc.assignment.model.api.RouteModel
import com.tcc.assignment.ui.adapter.StopAdapter
import com.tcc.assignment.viewmodel.RouteDetailViewModel
import kotlinx.android.synthetic.main.app_bar_main.view.*



class RouteDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityRouteDetailBinding
    private lateinit var viewModel: RouteDetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_route_detail)
        viewModel = ViewModelProviders.of(this).get(RouteDetailViewModel::class.java)

        setSupportActionBar(binding.appBar.toolbar)
        setupView()
        initviewModel()

    }

    fun setupView() {
        val data = intent.getParcelableExtra<RouteModel>("routeDetailData")
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.stopsRV.layoutManager = linearLayoutManager


        supportActionBar!!.title = data?.name
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val adapter = StopAdapter(this, data?.stop_times!!, viewModel)
        binding.stopsRV.adapter = adapter


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
package com.tcc.assignment.ui.module

import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcc.assignment.R
import com.tcc.assignment.base.BaseActivity
import com.tcc.assignment.databinding.ActivityMainBinding
import com.tcc.assignment.ui.adapter.StationAdapter
import com.tcc.assignment.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.app_bar_main.view.*


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setSupportActionBar(binding.appBar.toolbar)
        setupView()
        initviewModel()



        viewModel.fetchFinch()


    }

    fun setupView() {

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.stationRV.layoutManager = linearLayoutManager

        binding.swiperefresh.setOnRefreshListener {
            viewModel.fetchFinch()
            handler.postDelayed({
                binding!!.swiperefresh.isRefreshing = false
//                dismissProgressDialog()
            }, 1000)

        }



    }

    fun initviewModel() {
        var adapter = StationAdapter(this, listOf())
        binding.stationRV.adapter = adapter
        viewModel.getFinch().observe(this, Observer {
            if(binding.stationRV.adapter == null) {
                adapter = StationAdapter(this, it.stops)
                adapter.update(it.stops)
            } else {
//                adapter = StationAdapter(this, it.stops)
//                binding.stationRV.adapter = adapter
                adapter.update(it.stops)
            }


        })
    }





}
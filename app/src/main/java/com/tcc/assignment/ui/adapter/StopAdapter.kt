package com.tcc.assignment.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tcc.assignment.R
import com.tcc.assignment.model.api.RouteModel
import com.tcc.assignment.model.api.StopTimesModel
import com.tcc.assignment.ui.module.RouteActivity
import com.tcc.assignment.ui.viewholder.StationViewHolder
import com.tcc.assignment.ui.viewholder.StopViewHolder
import com.tcc.assignment.viewmodel.RouteDetailViewModel

class StopAdapter(private var ctx: Context, private var lists: List<StopTimesModel>, private var viewModel: RouteDetailViewModel): RecyclerView.Adapter<StopViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StopViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_stop, parent, false)

//        viewModel = AttendanceLegendActivityViewModel(app = )
        return StopViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: StopViewHolder, position: Int) {
        val item = lists[position]
        holder.destinationTV.text = item.shape


        holder.departureTimeTV.text = viewModel.convertTimeStampToDate(item.departure_timestamp!!)



    }
    fun update(list: List<StopTimesModel>) {
        this.lists = list
        notifyDataSetChanged()
    }




}
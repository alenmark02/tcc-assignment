package com.tcc.assignment.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tcc.assignment.R
import com.tcc.assignment.model.api.StopModel
import com.tcc.assignment.ui.module.RouteActivity
import com.tcc.assignment.ui.viewholder.StationViewHolder

class StationAdapter(private var ctx: Context, private var lists: List<StopModel>): RecyclerView.Adapter<StationViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_station, parent, false)

//        viewModel = AttendanceLegendActivityViewModel(app = )
        return StationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val item = lists[position]
        holder.stationNameTV.text = item.name

        if(item.routes!!.isNotEmpty()) {
            holder.arrowIV.visibility = View.VISIBLE
            val intent = Intent(ctx, RouteActivity::class.java)
            holder.itemView.setOnClickListener {
                intent.putExtra("routeData", item)
                ctx.startActivity(intent)
            }
        } else {
            holder.arrowIV.visibility = View.GONE
        }

    }
    fun update(list: List<StopModel>) {
        this.lists = list
        notifyDataSetChanged()
    }


}
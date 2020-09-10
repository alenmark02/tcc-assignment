package com.tcc.assignment.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tcc.assignment.R
import com.tcc.assignment.model.api.RouteModel
import com.tcc.assignment.ui.module.RouteDetailActivity
import com.tcc.assignment.ui.viewholder.RoutesViewHolder

class RoutesAdapter(private var ctx: Context, private var lists: List<RouteModel>): RecyclerView.Adapter<RoutesViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_routes, parent, false)

//        viewModel = AttendanceLegendActivityViewModel(app = )
        return RoutesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: RoutesViewHolder, position: Int) {
        val item = lists[position]
        holder.routesNameTV.text = item.name

        if(item.stop_times!!.isNotEmpty()) {
            holder.arrowIV.visibility = View.VISIBLE
            val intent = Intent(ctx, RouteDetailActivity::class.java)
            holder.itemView.setOnClickListener {
                intent.putExtra("routeDetailData", item)
                ctx.startActivity(intent)
            }
        } else {
            holder.arrowIV.visibility = View.GONE
        }

    }
    fun update(list: List<RouteModel>) {
        this.lists = list
        notifyDataSetChanged()
    }


}
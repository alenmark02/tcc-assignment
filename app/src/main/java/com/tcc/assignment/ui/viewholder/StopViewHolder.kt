package com.tcc.assignment.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcc.assignment.R

class StopViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)  {


    var destinationTV: TextView = itemView.findViewById(R.id.destinationTV)
    var departureTimeTV: TextView = itemView.findViewById(R.id.departuretimeTV)



}
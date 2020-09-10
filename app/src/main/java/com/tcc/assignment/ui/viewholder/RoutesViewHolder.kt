package com.tcc.assignment.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcc.assignment.R

class RoutesViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)  {

    var routesNameTV: TextView = itemView.findViewById(R.id.routesNameTV)
    var arrowIV: ImageView = itemView.findViewById(R.id.arrowIV)

}
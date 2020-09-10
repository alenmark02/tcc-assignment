package com.tcc.assignment.model.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouteModel(
    var stop_times: List<StopTimesModel> = listOf(),
    var route_group_id: String? = "",
    var name: String? = "",
    var uri: String? = ""
) : Parcelable
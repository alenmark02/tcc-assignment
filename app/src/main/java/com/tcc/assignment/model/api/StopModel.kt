package com.tcc.assignment.model.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StopModel(

    var routes : List<RouteModel>? = listOf(),
    var name: String? = "",
    var uri: String = "",
    var agency: String = ""
) : Parcelable
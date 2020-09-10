package com.tcc.assignment.model.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StopTimesModel(

    var departure_time: String? = "",
    var shape: String? = "",
    var departure_timestamp: Long? = 0,
    var service_id: Int
) : Parcelable
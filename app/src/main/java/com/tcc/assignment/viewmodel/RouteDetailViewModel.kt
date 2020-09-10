package com.tcc.assignment.viewmodel

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*


class RouteDetailViewModel : ViewModel() {

    fun convertTimeStampToDate(time: Long) : String {
        val sdf = SimpleDateFormat("hh:mm a", Locale.CANADA)
        sdf.timeZone = TimeZone.getTimeZone("GMT-4");
        val netDate = Date(time * 1000)

        return sdf.format(netDate)

    }


}
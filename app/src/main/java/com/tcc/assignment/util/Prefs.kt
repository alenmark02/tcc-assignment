package com.tcc.assignment.util

import android.content.Context
import android.content.SharedPreferences
import com.tcc.assignment.R

/**
 * Created by Alen Mark Peñoso on 07/11/2019.
 */


class Prefs(context: Context) {

    val prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.prefs), Context.MODE_PRIVATE)



    fun clear() {
//        prefs.all.clear()
        try {
            prefs.edit().clear().apply()
        } catch (e: Exception) {


        }
    }


    var fname: String?
        get() = prefs.getString("fname", null)
        set(value) = prefs.edit().putString("fname", value).apply()

    var mname: String?
        get() = prefs.getString("mname", null)
        set(value) = prefs.edit().putString("mname", value).apply()


    var lname: String?
        get() = prefs.getString("lname", null)
        set(value) = prefs.edit().putString("lname", value).apply()

    var email: String?
        get() = prefs.getString("email", null)
        set(value) = prefs.edit().putString("email", value).apply()






}
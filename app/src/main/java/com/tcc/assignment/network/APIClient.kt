package com.tcc.assignment.network

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting
import com.tcc.assignment.BuildConfig
import com.tcc.assignment.util.Constants


sealed class APIClient : FuelRouting {



    class GetFinchStation: APIClient()


    override val body: String?
        get() = null
    override val bytes: ByteArray?
        get() = null


    override val basePath: String
        get() {
            return when (this) {
                is GetFinchStation -> BuildConfig.BASE_URL
            }

        }

    override val headers: Map<String, String>?
        get() {
            return when (this) {

                is GetFinchStation -> emptyMap()
                else -> emptyMap()

            }

        }


    override val method: Method
        get() {
            return when (this) {
                is GetFinchStation -> Method.GET
                else -> Method.POST

            }
        }
    override val params: List<Pair<String, Any?>>?
        get() {
            return when (this) {
                else -> emptyList()

            }
        }
    override val path: String
        get() {
            return when (this) {
                is GetFinchStation -> Constants.fintch_station
                else -> ""

            }
        }
}
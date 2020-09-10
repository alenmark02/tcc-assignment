package com.tcc.assignment.model.api

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class FinchModel(

    var time: Long? =  0,
    var stops: List<StopModel> = listOf(),
    var uri: String? = "",
    var name: String? = ""
){
    class Deserializer: ResponseDeserializable<FinchModel> {
        override fun deserialize(content: String) = Gson().fromJson(content, FinchModel::class.java)!!
    }

}
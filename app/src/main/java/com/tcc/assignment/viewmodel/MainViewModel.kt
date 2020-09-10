package com.tcc.assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
import com.tcc.assignment.model.api.FinchModel
import com.tcc.assignment.network.APIClient


class MainViewModel : ViewModel() {



    val finchData = MutableLiveData<FinchModel>()


    fun fetchFinch() {
        Fuel.request(APIClient.GetFinchStation()).responseObject(
            FinchModel.Deserializer()){ _, _, result ->
            result.fold(success = {
                finchData.value = it

            },
                failure = {error ->
//                profile.value = ProfileModuleModel(message = it.message, status = it.response.statusCode)

                })
        }
    }

    fun getFinch() : MutableLiveData<FinchModel>{
        return finchData
    }


}
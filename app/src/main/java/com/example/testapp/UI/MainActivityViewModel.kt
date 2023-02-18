package com.example.testapp.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.models.ResponseData
import com.example.testapp.repository.ApiRepository
import com.example.testapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response


class MainActivityViewModel
    (
    val Repository: ApiRepository
            )
    : ViewModel() {
    val liveData:MutableLiveData<Resource<ResponseData>> = MutableLiveData()
    var cat_id=1
    fun getData()=viewModelScope.launch {
        liveData.postValue(Resource.Loading())
        val response=ApiRepository().getData(cat_id)
        liveData.postValue(handelResponse(response))


    }
    private fun handelResponse(response: Response<ResponseData>):Resource<ResponseData>{
        if(response.isSuccessful){
            response.body()?.let { responseData ->
                return Resource.Success(responseData)
            }
        }
        return Resource.Error(response.message())
    }
    }
package com.example.testapp.repository

import com.example.testapp.API.RetrofitInstance

class ApiRepository {
    suspend fun getData(cat_id:Int)=
        RetrofitInstance.api.getData(cat_id)

}
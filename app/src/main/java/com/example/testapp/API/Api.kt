package com.example.testapp.API

import com.example.testapp.models.ResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/get-content-by-category-id")
    suspend fun getData(
        @Query("category_id") category_id:Int=1
    ):Response<ResponseData>
}
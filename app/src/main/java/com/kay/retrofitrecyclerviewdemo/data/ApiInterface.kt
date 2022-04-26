package com.kay.retrofitrecyclerviewdemo.data

import retrofit2.http.GET

interface ApiInterface {
    // (1) create a get request (make sure to get the retrofit 'Call')
    @GET("posts"/* <- Adding the endpoint of the URL*/)
    suspend fun getData(): List<MyDataItem>
}
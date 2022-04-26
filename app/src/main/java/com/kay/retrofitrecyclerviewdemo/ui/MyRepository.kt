package com.kay.retrofitrecyclerviewdemo.ui

import com.kay.retrofitrecyclerviewdemo.data.ApiInterface
import com.kay.retrofitrecyclerviewdemo.data.MyDataItem

class MyRepository (val api: ApiInterface){
     suspend fun getData(): List<MyDataItem> {
        return api.getData()
    }
}
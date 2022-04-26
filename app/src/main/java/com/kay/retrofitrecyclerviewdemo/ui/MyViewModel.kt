package com.kay.retrofitrecyclerviewdemo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.retrofitrecyclerviewdemo.data.MyDataItem
import kotlinx.coroutines.launch
import java.lang.Exception

class MyViewModel (private val repo: MyRepository) : ViewModel(){
    var livedata = MutableLiveData<List<MyDataItem>>()
    var errorLiveData = MutableLiveData<String?>()

    fun getInfo() {
        viewModelScope.launch {
            try {
                val list = repo.getData()
                livedata.postValue(list)
                errorLiveData.postValue(null)
            } catch (e:Exception){
                errorLiveData.postValue("Error")
            }
        }
    }
}
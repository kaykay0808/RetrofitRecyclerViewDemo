package com.kay.retrofitrecyclerviewdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kay.retrofitrecyclerviewdemo.data.MyDataItem
import com.kay.retrofitrecyclerviewdemo.databinding.RowItemsBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    var userList = emptyList<MyDataItem>()

    class ViewHolder(val binding: RowItemsBinding) : RecyclerView.ViewHolder (binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(RowItemsBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.userIdTV.text = userList[position].userId.toString()
        holder.binding.titleTV.text = userList[position].title
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    fun setData(newData: List<MyDataItem>) {
        this.userList = newData
        notifyDataSetChanged()
    }
}
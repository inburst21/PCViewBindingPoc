package com.pointcare.ui.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, B: ViewBinding>(var mData: List<T>): RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected lateinit var mBinding : B

    fun setData(updatedData: List<T>) {
        this.mData = updatedData
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}
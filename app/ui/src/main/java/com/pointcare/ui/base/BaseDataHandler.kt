package com.pointcare.ui.base

import androidx.lifecycle.MutableLiveData

class BaseDataHandler<T> {
    private val mData = MutableLiveData<T>()

    fun setData(updatedData: T) {
        mData.value = updatedData
    }

    fun getData() : MutableLiveData<T> {
        return mData
    }
}
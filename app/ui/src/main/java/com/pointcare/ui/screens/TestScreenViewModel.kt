package com.pointcare.ui.screens

import androidx.lifecycle.MutableLiveData
import com.pointcare.ui.base.BaseViewModel
import kotlin.random.Random

class TestScreenViewModel : BaseViewModel() {
    val mData = MutableLiveData<String>()

    fun setData(string: String) {
        mData.value = string
    }

    fun randomString() {
        mData.value = Random.nextLong(Long.MAX_VALUE - 1).toString()
    }

    override fun onCleared() {
        super.onCleared()
        mData.value = ""
    }
}
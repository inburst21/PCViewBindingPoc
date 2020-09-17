package com.pointcare.ui.screens.test

import com.pointcare.ui.base.BaseDataHandler
import com.pointcare.ui.base.BaseViewModel
import kotlin.random.Random

class TestScreenViewModel : BaseViewModel() {

    private val mDataHandler = BaseDataHandler<String>()

    fun randomString() {
        mDataHandler.setData(Random.nextLong(Long.MAX_VALUE - 1).toString())
    }

    fun getData() = mDataHandler.getData()
}
package com.pointcare.ui.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import com.pointcare.ui.base.BoundFragment
import com.pointcare.ui.databinding.FragmentTestBinding

class TestScreen : BoundFragment<FragmentTestBinding, TestScreenViewModel>() {//todo remove generics maybe clean

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?) {
        mViewBinding = FragmentTestBinding.inflate(inflater, container, false)
        mViewModel = getViewModelFactory().create(TestScreenViewModel::class.java)
        //not sure about the controllers but it does clean up the code and separates logic
        TestController(mViewBinding, mViewModel, this)
        mViewModel.setData("Test")
    }
}
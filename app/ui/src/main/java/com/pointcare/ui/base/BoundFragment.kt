package com.pointcare.ui.base

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BoundFragment<B : ViewBinding, VM : BaseViewModel> : BaseFragment<VM>() {

    protected lateinit var mViewBinding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindView(inflater, container)
        return mViewBinding.root
    }

    abstract fun bindView(inflater: LayoutInflater, container: ViewGroup?)
    protected fun getViewModelFactory(): ViewModelProvider.AndroidViewModelFactory {
        return ViewModelProvider.AndroidViewModelFactory.getInstance(context!!.applicationContext as Application)
    }
}
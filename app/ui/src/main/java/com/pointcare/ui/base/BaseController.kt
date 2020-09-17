package com.pointcare.ui.base

import androidx.lifecycle.LifecycleOwner

abstract class BaseController<VM : BaseViewModel>(private val mViewModel: VM) {
    abstract fun observeViewModel(lifecycleOwner: LifecycleOwner)
}
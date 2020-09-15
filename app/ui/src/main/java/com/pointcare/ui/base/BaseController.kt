package com.pointcare.ui.base

abstract class BaseController<VM : BaseViewModel>(private val mViewModel: VM) {
    abstract fun observeViewModel()
}
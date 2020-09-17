package com.pointcare.ui.base

import androidx.viewbinding.ViewBinding

abstract class BoundController<B : ViewBinding, VM : BaseViewModel>(
    protected val mBinding: B,
    protected val mViewModel: VM,
) : BaseController<VM>(mViewModel)
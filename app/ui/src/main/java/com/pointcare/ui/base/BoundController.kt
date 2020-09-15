package com.pointcare.ui.base

import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

abstract class BoundController<B : ViewBinding, VM : BaseViewModel>(
    protected val mBinding: B,
    protected val mViewModel: VM,
    protected val mOwner: LifecycleOwner
) : BaseController<VM>(mViewModel)
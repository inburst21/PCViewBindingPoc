package com.pointcare.ui.screens.test

import androidx.lifecycle.LifecycleOwner
import com.pointcare.ui.base.BoundController
import com.pointcare.ui.databinding.FragmentTestBinding

class TestController(
    binding: FragmentTestBinding,
    viewModel: TestScreenViewModel,
) : BoundController<FragmentTestBinding, TestScreenViewModel>(binding, viewModel) {

    override fun observeViewModel(lifecycleOwner: LifecycleOwner) {
        mViewModel.getData().observe(lifecycleOwner, {
            mBinding.itemText.text = it.orEmpty()
            mBinding.itemText2.text = it
            mBinding.root.setOnClickListener { mViewModel.randomString() }
        })
    }
}
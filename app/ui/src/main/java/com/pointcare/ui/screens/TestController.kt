package com.pointcare.ui.screens

import androidx.lifecycle.LifecycleOwner
import com.pointcare.ui.base.BoundController
import com.pointcare.ui.databinding.FragmentTestBinding

class TestController(
    binding: FragmentTestBinding,
    viewModel: TestScreenViewModel,
    owner: LifecycleOwner
) : BoundController<FragmentTestBinding, TestScreenViewModel>(binding, viewModel, owner) {

    override fun observeViewModel() {
        mViewModel.mData.observe(mOwner, {
            mBinding.itemText.text = it.orEmpty()
            mBinding.itemText2.text = it
            mBinding.root.setOnClickListener { mViewModel.randomString() }
        })
    }
}
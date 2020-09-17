package com.pointcare.ui.views.selectiondialog

import androidx.lifecycle.LifecycleOwner
import com.pointcare.ui.base.BoundController
import com.pointcare.ui.databinding.ViewTextBoxBinding

class SelectableTextController(
    mViewBinding: ViewTextBoxBinding,
    mViewModel: SelectionDialogViewModel,
) : BoundController<ViewTextBoxBinding, SelectionDialogViewModel>(mViewBinding, mViewModel) {
    override fun observeViewModel(lifecycleOwner: LifecycleOwner) {
        mBinding.root.setOnClickListener{ mViewModel.open() }
        mViewModel.getData().observe(lifecycleOwner, {
            mBinding.textSelectedItems.text = it.joinToString()
        })
    }
}
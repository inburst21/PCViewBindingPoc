package com.pointcare.ui.views.selectiondialog

import android.app.Dialog
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.pointcare.ui.R
import com.pointcare.ui.base.BoundController
import com.pointcare.ui.databinding.ViewDialogSelectionBinding
import com.pointcare.ui.views.selectiondialog.SelectionDialogViewModel.Companion.DialogState

class SelectableTextDialogController(
    binding: ViewDialogSelectionBinding,
    viewModel: SelectionDialogViewModel,
) : BoundController<ViewDialogSelectionBinding, SelectionDialogViewModel>(
    binding,
    viewModel
) {

    private val mDialog: Dialog = Dialog(binding.root.context)
    private var adapter: SelectableTextAdapter = SelectableTextAdapter(viewModel.cloneList().toMutableList())

    override fun observeViewModel(lifecycleOwner: LifecycleOwner) {
        initView()
        mViewModel.getData().observe(lifecycleOwner, {
            adapter.setData(it)
        })

        mViewModel.getDialogState().observe(lifecycleOwner, {
            when (it!!) {
                DialogState.OPEN -> showDialog()
                DialogState.FINISH -> hideDialog()
                DialogState.REVERT -> {
                    adapter = SelectableTextAdapter(mViewModel.cloneList().toMutableList())
                    hideDialog()
                }
            }
        })

        mDialog.setContentView(mBinding.root)
    }

    private fun initView() {
        mBinding.titleBar.textTitle.text = "Filler Test Text"
        mBinding.confirmBar.buttonPositive.text = mBinding.root.context.getString(R.string.ok)
        mBinding.confirmBar.buttonNegative.text = mBinding.root.context.getString(R.string.cancel)
        mBinding.confirmBar.buttonPositive.setOnClickListener { mViewModel.onPositive(adapter.mData) }
        mBinding.confirmBar.buttonNegative.setOnClickListener {
            mViewModel.onNegative()
            adapter.setData(mViewModel.cloneList())
        }
        mBinding.viewList.viewList.adapter = adapter
        mBinding.viewList.viewList.layoutManager = LinearLayoutManager(mBinding.root.context)
    }

    private fun showDialog() {
        mDialog.show()
    }

    private fun hideDialog() {
        mDialog.dismiss()
    }
}
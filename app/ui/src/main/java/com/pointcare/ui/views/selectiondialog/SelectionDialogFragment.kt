package com.pointcare.ui.views.selectiondialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.pointcare.ui.base.BoundFragment
import com.pointcare.ui.databinding.ViewDialogSelectionBinding
import com.pointcare.ui.databinding.ViewTextBoxBinding

class SelectionDialogFragment : BoundFragment<ViewTextBoxBinding, SelectionDialogViewModel>() {

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?) {
        mViewBinding = ViewTextBoxBinding.inflate(inflater, container, false)
        mViewModel = getViewModelFactory().create(SelectionDialogViewModel::class.java)
        //not sure about the controllers but it does clean up the code and separates logic
        mViewModel.setData(
            arrayListOf(
                SelectableText("Test One", false),
                SelectableText("Test One", false),
                SelectableText("Test One", false),
                SelectableText("Test One", false),
                SelectableText("Test One", false)
            )
        )
        SelectableTextController(mViewBinding, mViewModel).observeViewModel(this)
        val binding = ViewDialogSelectionBinding.inflate(LayoutInflater.from(context))
        SelectableTextDialogController(binding, mViewModel).observeViewModel(this)


    }
}
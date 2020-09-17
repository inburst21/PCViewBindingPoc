package com.pointcare.ui.views.selectiondialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.pointcare.ui.base.BaseAdapter
import com.pointcare.ui.base.BaseViewHolder
import com.pointcare.ui.databinding.ItemSelectableTextBinding

class SelectableTextAdapter(list: List<SelectableText>) : BaseAdapter<SelectableText, ItemSelectableTextBinding>(list) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<SelectableText> {
        mBinding = ItemSelectableTextBinding.inflate(LayoutInflater.from(parent.context))
        return SelectableTextViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<SelectableText>, position: Int) {
        SelectableTextBinder().bind(mBinding, mData[position])
    }
}

class SelectableTextViewHolder(binding: ItemSelectableTextBinding) : BaseViewHolder<SelectableText>(binding.root)
package com.pointcare.ui.views.selectiondialog

import com.pointcare.ui.base.BaseBinder
import com.pointcare.ui.databinding.ItemSelectableTextBinding

class SelectableTextBinder : BaseBinder<ItemSelectableTextBinding, SelectableText>() {
    override fun bind(binding: ItemSelectableTextBinding, model: SelectableText) {
        binding.item.text = model.string
        binding.item.isChecked = model.checked
        binding.item.setOnClickListener {
            val checked = binding.item.isChecked
            binding.item.isChecked = !checked
            model.checked = !checked
        }
    }
}
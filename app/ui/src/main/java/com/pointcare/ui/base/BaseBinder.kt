package com.pointcare.ui.base

import androidx.viewbinding.ViewBinding

abstract class BaseBinder<B : ViewBinding, M> {
    abstract fun bind(binding: B, model: M)
}
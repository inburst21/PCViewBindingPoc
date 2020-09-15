package com.pointcare.ui.base

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel> : Fragment(), View.OnClickListener {

    protected lateinit var mViewModel: VM

    fun showMessage(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View?) {}
}
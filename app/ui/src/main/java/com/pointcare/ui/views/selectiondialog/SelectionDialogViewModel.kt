package com.pointcare.ui.views.selectiondialog

import androidx.lifecycle.LiveData
import com.pointcare.ui.base.BaseDataHandler
import com.pointcare.ui.base.BaseViewModel

class SelectionDialogViewModel : BaseViewModel() {

    companion object {
        enum class DialogState {
            OPEN,
            FINISH,
            REVERT
        }
    }

    private val mDataHandler = BaseDataHandler<List<SelectableText>>()
    private val mDialogState = BaseDataHandler<DialogState>()


    fun onPositive(list: List<SelectableText>) {
        setData(list)
        mDialogState.setData(DialogState.FINISH)
    }

    fun onNegative() {
        mDialogState.setData(DialogState.REVERT)
    }

    fun getData() = mDataHandler.getData()

    fun setData(data: List<SelectableText>) {
        mDataHandler.setData(cloneList(data))
    }

    private fun cloneList(data: List<SelectableText>): MutableList<SelectableText> {
        val temp = mutableListOf<SelectableText>()
        for(item in data) {
            temp.add(SelectableText(item.string, item.checked))
        }
        return temp
    }

    fun getDialogState(): LiveData<DialogState> {
        return mDialogState.getData()
    }

    fun open() {
        mDataHandler.setData(cloneList())
        mDialogState.setData(DialogState.OPEN)
    }

    fun cloneList() : MutableList<SelectableText> {
        return cloneList(mDataHandler.getData().value!!)
    }
}
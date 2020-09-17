package com.pointcare.pcviewbindingpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pointcare.ui.screens.test.TestFragment
import com.pointcare.ui.views.selectiondialog.SelectionDialogFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, SelectionDialogFragment()).commit()
        }
    }
}
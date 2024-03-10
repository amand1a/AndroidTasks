package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() , NoticeDialogFragment.NoticeDialogListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {

    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {

    }
}
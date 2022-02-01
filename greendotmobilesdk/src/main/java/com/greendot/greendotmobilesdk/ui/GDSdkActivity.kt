package com.greendot.greendotmobilesdk.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.greendot.greendotmobilesdk.R
import com.greendot.greendotmobilesdk.databinding.ActivityGdSdkBinding

class GDSdkActivity: AppCompatActivity() {

    private lateinit var binding: ActivityGdSdkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gd_sdk)
    }

}

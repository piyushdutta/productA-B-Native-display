package com.example.ctdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ctdemo.databinding.ActivityInAppBinding

class InAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_in_app)

        binding.buttonAlert.setOnClickListener {
            MyApplication.getCleverTapDefaultInstance()
                .pushEvent("In App Alert")
        }

        binding.buttonCover.setOnClickListener {
            MyApplication.getCleverTapDefaultInstance()
                .pushEvent("In App Cover")
        }

        binding.buttonCustomHtml.setOnClickListener {
            MyApplication.getCleverTapDefaultInstance()
                .pushEvent("In App Custom HTML")
        }

        binding.buttonFooter.setOnClickListener {
            MyApplication.getCleverTapDefaultInstance()
                .pushEvent("In App Footer")
        }

        binding.buttonHalfInterstitial.setOnClickListener {
            MyApplication.getCleverTapDefaultInstance()
                .pushEvent("In App Half Interstitial")
        }

        binding.buttonInterstitial.setOnClickListener {
            MyApplication.getCleverTapDefaultInstance()
                .pushEvent("In App Interstitial")
        }

        binding.buttonHeader.setOnClickListener {
            MyApplication.getCleverTapDefaultInstance()
                .pushEvent("In App Header")
        }
    }
}

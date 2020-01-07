package com.example.ctdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clevertap.android.sdk.CTInboxListener
import com.clevertap.android.sdk.CTInboxStyleConfig


class AppInboxActivity : AppCompatActivity(), CTInboxListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_inbox)

        MyApplication.getCleverTapDefaultInstance().ctNotificationInboxListener = this
        //Initialize the inbox and wait for callbacks on overridden methods
        MyApplication.getCleverTapDefaultInstance().initializeInbox()
    }

    override fun inboxDidInitialize() {
        val tabs: ArrayList<String> = ArrayList()
        tabs.add("Promotions")
        tabs.add("Offers")
        tabs.add("Others") //We support upto 2 tabs only. Additional tabs will be ignored


        val styleConfig = CTInboxStyleConfig()
        styleConfig.tabs = tabs //Do not use this if you don't want to use tabs

        styleConfig.tabBackgroundColor = "#FF0000" //provide Hex code in string ONLY

        styleConfig.selectedTabIndicatorColor = "#0000FF"
        styleConfig.selectedTabColor = "#000000"
        styleConfig.unselectedTabColor = "#FFFFFF"
        styleConfig.backButtonColor = "#FF0000"
        styleConfig.navBarTitleColor = "#FF0000"
        styleConfig.navBarTitle = "MY INBOX"
        styleConfig.navBarColor = "#FFFFFF"
        styleConfig.inboxBackgroundColor = "#00FF00"

        MyApplication.getCleverTapDefaultInstance()
            .showAppInbox(styleConfig) //Opens activity tith Tabs

        //OR
        //OR
        MyApplication.getCleverTapDefaultInstance()
            .showAppInbox() //Opens Activity with default style config

    }

    override fun inboxMessagesDidUpdate() {

    }
}

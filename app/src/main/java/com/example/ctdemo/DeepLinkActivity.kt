package com.example.ctdemo

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ctdemo.databinding.ActivityDeepLinkBinding

class DeepLinkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeepLinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deep_link)

        val extras = intent.extras
        if (extras != null) {
            val actionId = extras.getString("actionId")
            if (actionId != null) {
                val autoCancel = extras.getBoolean("autoCancel", true)
                val notificationId = extras.getInt("notificationId", -1)
                if (autoCancel && notificationId > -1) {
                    val notifyMgr =
                        applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                    notifyMgr.cancel(notificationId) // the bit that cancels the notification
                }
                Toast.makeText(
                    baseContext, "Action ID is: $actionId",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

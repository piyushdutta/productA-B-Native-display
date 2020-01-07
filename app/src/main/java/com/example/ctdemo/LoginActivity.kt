package com.example.ctdemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ctdemo.databinding.ActivityLoginBinding
import java.util.*
import kotlin.collections.HashMap


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var user: User

    private lateinit var sharedpreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        user = User()

        binding.user = user

        binding.buttonLogin.setOnClickListener {
            if (isValid()) {
                Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()

                val loginActionProperties = HashMap<String, Any>()

                loginActionProperties["User Name"] = user.userName!!
                loginActionProperties["Login Date"] = Date()


                sharedpreferences = getSharedPreferences(
                    "PREF",
                    Context.MODE_PRIVATE
                )
                val editor: SharedPreferences.Editor = sharedpreferences.edit()
                editor.putBoolean("login", true)
                editor.apply()

                MyApplication.getCleverTapDefaultInstance()
                    .pushEvent("Login", loginActionProperties)

                goToMain()
            }
        }
    }

    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun isValid(): Boolean {
        var valid = true
        var errorMessage: String? = null

        if (user.password.isNullOrEmpty()) {
            valid = false
            errorMessage = "Enter Password"
        }

        if (user.userName.isNullOrEmpty()) {
            valid = false
            errorMessage = "Enter Username"
        }

        if (!valid) {
            Toast.makeText(this, errorMessage!!, Toast.LENGTH_SHORT).show()
        }
        return valid
    }
}

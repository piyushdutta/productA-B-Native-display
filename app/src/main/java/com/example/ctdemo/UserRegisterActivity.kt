package com.example.ctdemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ctdemo.databinding.ActivityUserRegisterBinding


class UserRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserRegisterBinding
    private lateinit var user: User
    private lateinit var sharedpreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_register)

        sharedpreferences = getSharedPreferences(
            "PREF",
            Context.MODE_PRIVATE
        )

        if (sharedpreferences.getBoolean("login", false)) {
            goToMain()
        } else {
            user = User()

            binding.user = user

            binding.buttonRegister.setOnClickListener {
                if (isValid()) {
                    Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show()
                    val profileUpdate = HashMap<String, Any>()
                    profileUpdate["Name"] = user.name!!
                    profileUpdate["Identity"] = user.userName!!
                    profileUpdate["Email"] = user.email!!
                    profileUpdate["UserName"] = user.userName!!
                    profileUpdate["UserName"] = user.userName!!

                    MyApplication.getCleverTapDefaultInstance().onUserLogin(profileUpdate)
                    goToLogin()
                }
            }
        }
    }


    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
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

        if (user.email.isNullOrEmpty()) {
            valid = false
            errorMessage = "Enter Email"
        }
        if (user.name.isNullOrEmpty()) {
            valid = false
            errorMessage = "Enter Name"
        }

        if (!valid) {
            Toast.makeText(this, errorMessage!!, Toast.LENGTH_SHORT).show()
        }
        return valid
    }
}

package com.example.tylerpotts_lifemanagementapp_courseproject

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.activity_setting.loginBtn

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()



        loginBtn.setOnClickListener() {
            if (emailLoginId.text.trim().toString().isNotEmpty() || passwordLoginId.text.trim()
                    .toString().isNotEmpty()
            ) {
                login(emailLoginId.text.trim().toString(), passwordLoginId.text.trim().toString())
            } else {
                Snackbar.make(
                    findViewById(R.id.loginBtn), "Check your username or password then try again.",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    fun login(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->

            if (task.isSuccessful) {
                var intent1 = Intent(this, MainActivity::class.java)
                startActivity(intent1)
            } else {
                Snackbar.make(
                    findViewById(R.id.loginBtn),
                    "Enter a valid username or password",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
    fun go2Setting(view: View) {
        var intentSetting = Intent(this, SettingActivity::class.java)
        startActivity(intentSetting)
    }
    }

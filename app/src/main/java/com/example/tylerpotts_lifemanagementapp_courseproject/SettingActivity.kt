package com.example.tylerpotts_lifemanagementapp_courseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        signupBtn.setOnClickListener{
            startActivity(Intent(this, Signup::class.java))
        }

        loginBtn.setOnClickListener{
            startActivity(Intent(this, Login::class.java ))
        }
    }

    fun go2Main(view: View) {
        var intent1 = Intent(this, MainActivity::class.java)
        startActivity(intent1)
    }

    fun go2Help(view: View) {
        var intentHelp = Intent(this, HelpActivity::class.java)
        startActivity(intentHelp)
    }
}
package com.example.tylerpotts_lifemanagementapp_courseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }

    fun go2Setting(view: View) {
        var intentSetting = Intent(this, SettingActivity::class.java)
        startActivity(intentSetting)
    }

    fun go2Help2(view: View) {
        var intentHelp2 = Intent(this, Help2Activity::class.java)
        startActivity(intentHelp2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.helpmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.purposeId -> {
                startActivity(Intent(this, HelpActivity::class.java))
                return super.onOptionsItemSelected(item) }
            R.id.timerId -> {
                startActivity(Intent(this, Help2Activity::class.java))
                return super.onOptionsItemSelected(item) }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }


}

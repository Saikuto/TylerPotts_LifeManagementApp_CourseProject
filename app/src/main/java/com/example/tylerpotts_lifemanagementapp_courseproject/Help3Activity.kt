package com.example.tylerpotts_lifemanagementapp_courseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

class Help3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help3)
    }
    fun go2Timer (view: View) {
        var intenttimer = Intent(this, Help2Activity::class.java)
        startActivity(intenttimer)
    }
    fun go2calendar (view: View) {
        var intentcalendar = Intent(this, Help4Activity::class.java)
        startActivity(intentcalendar)
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

            R.id.alarmId -> {
                startActivity(Intent(this, Help3Activity::class.java))
                return super.onOptionsItemSelected(item) }
            R.id.calendarId -> {
                startActivity(Intent(this, Help4Activity::class.java))
                return super.onOptionsItemSelected(item) }
            R.id.notesId -> {
                startActivity(Intent(this, Help5Activity::class.java))
                return super.onOptionsItemSelected(item) }
            R.id.checklistId -> {
                startActivity(Intent(this, Help6Activity::class.java))
                return super.onOptionsItemSelected(item) }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
package com.example.tylerpotts_lifemanagementapp_courseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

class Help5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help5)
    }
    fun go2calendar (view: View) {
        var intentcalendar = Intent(this, Help4Activity::class.java)
        startActivity(intentcalendar)
    }
    fun go2check (view: View) {
        var intentcheck = Intent(this, Help6Activity::class.java)
        startActivity(intentcheck)
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
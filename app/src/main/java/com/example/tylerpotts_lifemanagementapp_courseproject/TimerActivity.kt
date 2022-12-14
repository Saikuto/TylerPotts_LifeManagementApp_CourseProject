package com.example.tylerpotts_lifemanagementapp_courseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

import android.view.View

import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_alarm.*
import kotlinx.android.synthetic.main.activity_timer.*
import kotlin.math.round

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        countdownbtn.setOnClickListener{ view ->
            val seconds = getIntent()?.getExtras()?.getLong("addTimetxt")
            if (seconds != null) {
                val milliseconds = seconds * 1000
                startTimer(milliseconds)
            }
        }
    }

    fun startTimer(timeInMilliseconds: Long){
        var timeRemaining = 0.0
        object : CountDownTimer(timeInMilliseconds, 1000){
            override fun onTick(timeInMilliseconds: Long) {
                val roundSeconds = round(timeInMilliseconds.toDouble() / 1000)
                if (roundSeconds != timeRemaining) {
                    timeRemaining = roundSeconds
                    val millisUntilFinish = (timeRemaining * 1000).toLong()
                    val minutesRemaining = millisUntilFinish / 60000
                    val secondsRemaining = (millisUntilFinish % 60000) / 1000
                    val minutes = appendZero(minutesRemaining)
                    val seconds = appendZero(secondsRemaining)
                    val timetxt = "${minutes}:${seconds}"
                    timeViewtxt.setText(timetxt)
                }
            }

            override fun onFinish() {
               timeViewtxt.text = "Finished"
            }
        }.start()
    }

    fun appendZero(time: Long): String{
        val timeString = time.toString()
        return if ( time < 10) "0$timeString" else timeString
    }


    fun go2AlarmActivity(view: View) {
        var intent1 = Intent(this, AlarmActivity::class.java)
        startActivity(intent1)
    }
}
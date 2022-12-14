package com.example.tylerpotts_lifemanagementapp_courseproject

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tylerpotts_lifemanagementapp_courseproject.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kotlinx.android.synthetic.main.activity_alarm.*
import java.util.*

class AlarmActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var picker : MaterialTimePicker
    private lateinit var calendar : Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_alarm)
      // setContentView(binding.root)
        createNotificationChannel()

        selectbtn.setOnClickListener{

            showTimePicker()
        }

        setAlarmbtn.setOnClickListener{

            setAlarm()
        }


        cancelbtn.setOnClickListener{

            cancelAlarm()

        }




    }
    private fun showTimePicker() {

        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        picker.show(supportFragmentManager,"LifeManagement")

        picker.addOnPositiveButtonClickListener{
            if (picker.hour > 12){
                selectedTime.setText(String.format("%02d",picker.hour -12) + " : " + String.format("%02d",picker.minute) + "PM")

            } else{
                selectedTime.setText(String.format("%02d",picker.hour) + " : " + String.format("%02d",picker.minute) + "AM")

            }
            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }


    }


    private fun cancelAlarm() {
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)

        alarmManager.cancel(pendingIntent)
        Toast.makeText(this,"Alarm Cancelled", Toast.LENGTH_LONG).show()
    }


    private fun setAlarm() {

        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,pendingIntent
        )
        Toast.makeText(this,"Alarm set Successfully",Toast.LENGTH_SHORT).show()
    }


    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val name : CharSequence = "LifeManagement"
            val description = "Channel for alarm manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("LifeManagement",name, importance)
            channel.description = description
            val notificationManager= getSystemService(
                NotificationManager::class.java)

                notificationManager.createNotificationChannel(channel)
        }

    }

    fun go2addTimer(view: View) {
        val intentTimer = Intent(this,TimerActivity::class.java)
        intentTimer.putExtra("addTimetxt",parseSeconds())
        startActivity(intentTimer)
    }

    private fun parseSeconds(): Long {
        if (addTimetxt?.text != null){
            return addTimetxt.text.toString().toLong()
        }
        return 0
    }
    fun go2Main(view: View) {
        var intent1 = Intent(this, MainActivity::class.java)
        startActivity(intent1)
    }

}
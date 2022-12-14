package com.example.tylerpotts_lifemanagementapp_courseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readFireStoreData()
    }

    fun go2AlarmActivity(view: View) {
        var intent1 = Intent(this,AlarmActivity::class.java)
        startActivity(intent1)
    }

    fun go2CalendarActivity(view: View) {
        var intent2 = Intent(this,CalendarActivity::class.java)
        startActivity(intent2)
    }

    fun go2NotesActivity(view: View) {
        var intent3 = Intent(this,NotesActivity::class.java)
        startActivity(intent3)
    }

    fun go2ChecklistActivity(view: View) {
        var intent4 = Intent(this,ChecklistActivity::class.java)
        startActivity(intent4)
    }

    fun go2SettingsActivity(view: View) {
        var intent5 = Intent(this,SettingActivity::class.java)
        startActivity(intent5)
    }

    fun readFireStoreData(){
        val db = FirebaseFirestore.getInstance()

        db.collection("Customer")
            .get()
            .addOnCompleteListener{
                val result: StringBuffer = StringBuffer()
                if (it.isSuccessful) {
                    for (document in it.result!!){
                        result.append(document.data.getValue("Name")) .append("     ")
                    }
                    readNameId.setText(result)
                }
            }
    }
}
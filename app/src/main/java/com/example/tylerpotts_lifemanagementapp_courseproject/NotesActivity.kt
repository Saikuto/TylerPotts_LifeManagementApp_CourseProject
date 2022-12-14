package com.example.tylerpotts_lifemanagementapp_courseproject

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.Query
import com.google.firebase.ktx.Firebase

class NotesActivity : AppCompatActivity() {

        private lateinit var recyclerView: RecyclerView
        private lateinit var addNotebtn: FloatingActionButton
        private lateinit var noteDataAccess: NoteDataAccess
        private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        recyclerView= findViewById(R.id.recyclerView)
        addNotebtn = findViewById(R.id.addNotebtn)
        noteDataAccess = NoteDataAccess()
        auth = Firebase.auth

        addNotebtn.setOnClickListener{
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

    }



    fun go2Main(view: View) {
        var intent1 = Intent(this, MainActivity::class.java)
        startActivity(intent1)
    }
}
package com.example.tylerpotts_lifemanagementapp_courseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNoteActivity : AppCompatActivity() {

        private lateinit var noteEditText: EditText
        private lateinit var addbtn : Button
        private lateinit var noteDataAccess : NoteDataAccess

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        noteEditText = findViewById(R.id.noteEditText)
        addbtn = findViewById(R.id.addbtn)
        noteDataAccess = NoteDataAccess()

        addbtn.setOnClickListener{
            val note = noteEditText.text.toString()
            if(note.isNotEmpty()) {
                noteDataAccess.addNote(note)
                val intent = Intent(this,NotesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
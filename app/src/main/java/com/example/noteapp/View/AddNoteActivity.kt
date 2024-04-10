package com.example.noteapp.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.Model.Note
import com.example.noteapp.NoteApplication
import com.example.noteapp.R
import com.example.noteapp.ViewModel.NoteViewModel
import com.example.noteapp.ViewModel.NoteViewModelFactory

class AddNoteActivity : AppCompatActivity() {

    lateinit var tvTitle: TextView
    lateinit var tvDesc: TextView
    lateinit var btnCancel: Button
    lateinit var btnSubmit: Button
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        tvTitle = findViewById(R.id.editTextTitle)
        tvDesc = findViewById(R.id.editTextDesc)
        btnCancel = findViewById(R.id.buttonCancel)
        btnSubmit = findViewById(R.id.buttonSave)
        btnSubmit.setOnClickListener {
            val title = tvTitle.text.toString()
            val desc =  tvDesc.text.toString()
            val noteViewModelFactory = NoteViewModelFactory((application as NoteApplication).repository)
            noteViewModel = ViewModelProvider(this, noteViewModelFactory).get(NoteViewModel::class.java)
            noteViewModel.insert(Note(title, desc))
            val intent = Intent(this@AddNoteActivity, MainActivity::class.java)
            startActivity( intent)
        }

        btnCancel.setOnClickListener {
            val intent = Intent(this@AddNoteActivity, MainActivity::class.java)
            startActivity( intent)
        }
    }
}
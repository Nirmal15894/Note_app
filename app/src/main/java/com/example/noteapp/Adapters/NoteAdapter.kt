package com.example.noteapp.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.Adapters.NoteAdapter.NoteViewHolder
import com.example.noteapp.Model.Note
import com.example.noteapp.R
import com.example.noteapp.View.AddNoteActivity
import com.example.noteapp.View.MainActivity

class NoteAdapter: RecyclerView.Adapter<NoteViewHolder>() {

    var notes: List<Note> = ArrayList()

    lateinit var context: Context

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val tvDesc: TextView = itemView. findViewById(R.id.textViewDesc)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        context = parent.context
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var currentNote: Note = notes[position]
        holder.tvTitle.text = currentNote.title
        holder.tvDesc.text = currentNote.description
    }

    fun setNote(myNotes: List<Note>) {
        this.notes = myNotes
    }
}
package com.jeezzzz.notesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jeezzzz.notesapp.R
import com.jeezzzz.notesapp.databinding.NoteLayoutBinding
import com.jeezzzz.notesapp.fragments.HomeFragment
import com.jeezzzz.notesapp.fragments.HomeFragmentDirections
import com.jeezzzz.notesapp.model.Note

class NoteAdapter(private val requireContext: Context, private val noteList: List<Note>)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val itemBinding: NoteLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = noteList[position]

        holder.itemBinding.noteTitle.text = currentItem.title
        holder.itemBinding.noteDesc.text = currentItem.desc

        holder.itemView.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(currentItem)
            Navigation.findNavController(it).navigate(action)
        }
    }

}

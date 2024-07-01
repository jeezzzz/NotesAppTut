package com.jeezzzz.notesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.jeezzzz.notesapp.R
import com.jeezzzz.notesapp.databinding.FragmentEditNoteBinding
import com.jeezzzz.notesapp.model.Note
import com.jeezzzz.notesapp.viewmodel.NoteViewModel

class EditNoteFragment : Fragment() {

    val notes by navArgs<EditNoteFragmentArgs>()
    lateinit var binding: FragmentEditNoteBinding
    val viewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNoteBinding.inflate(layoutInflater, container, false)
        binding.editNoteTitle.setText(notes.note!!.title)
        binding.editNoteDesc.setText(notes.note!!.desc)
        binding.editNoteFab.setOnClickListener {
            val title=binding.editNoteTitle.text.toString()
            val desc=binding.editNoteDesc.text.toString()

            if(title.isNotEmpty() && desc.isNotEmpty()){
                val data= Note(notes.note!!.id,title,desc)
                viewModel.addNote(data)
                Toast.makeText(context, "Note Updated", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(it).navigate(R.id.action_editNoteFragment_to_homeFragment)
            }else{
                Toast.makeText(context, "Enter Details", Toast.LENGTH_SHORT).show()
            }
        }
        binding.deleteNoteFab.setOnClickListener {
            viewModel.deleteNote(notes.note!!)
            Navigation.findNavController(it).navigate(R.id.action_editNoteFragment_to_homeFragment)
        }
        return binding.root
    }
}
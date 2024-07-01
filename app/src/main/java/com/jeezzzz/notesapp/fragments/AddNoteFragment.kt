package com.jeezzzz.notesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.jeezzzz.notesapp.R
import com.jeezzzz.notesapp.databinding.FragmentAddNoteBinding
import com.jeezzzz.notesapp.model.Note
import com.jeezzzz.notesapp.viewmodel.NoteViewModel

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding
    val viewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentAddNoteBinding.inflate(layoutInflater,container,false)

        binding.saveNoteFab.setOnClickListener {  view ->
            val title=binding.addNoteTitle.text.toString()
            val desc=binding.addNoteDesc.text.toString()

            if(title.isNotEmpty() && desc.isNotEmpty()){
                val data=Note(null,title,desc)
                viewModel.addNote(data)
                Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.action_addNoteFragment_to_homeFragment)

            }else{
                Toast.makeText(context, "Enter Details", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}
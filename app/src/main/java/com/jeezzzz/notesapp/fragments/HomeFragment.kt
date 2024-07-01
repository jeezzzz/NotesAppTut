package com.jeezzzz.notesapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jeezzzz.notesapp.R
import com.jeezzzz.notesapp.adapter.NoteAdapter
import com.jeezzzz.notesapp.databinding.FragmentHomeBinding
import com.jeezzzz.notesapp.viewmodel.NoteViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: NoteViewModel by viewModels()
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        // Observe LiveData
        viewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
            if(notesList!=null){
                if (notesList.isNotEmpty()){
                    binding.homeRecyclerView.visibility=View.VISIBLE
                    binding.emptyNotesImage.visibility=View.GONE
                }
                else{
                    binding.homeRecyclerView.visibility=View.GONE
                    binding.emptyNotesImage.visibility=View.VISIBLE
                }
            }
            binding.homeRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.homeRecyclerView.adapter = NoteAdapter(requireContext(),notesList)
        }

        binding.addNoteFab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addNoteFragment)
        }

        return binding.root
    }
}

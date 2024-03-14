package com.ilsa1000ri.weathersecretary.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ilsa1000ri.weathersecretary.databinding.FragmentTimetableBinding

class TimetableFragment : Fragment() {

    private var _binding: FragmentTimetableBinding ?= null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val timetableViewModel =
            ViewModelProvider(this).get(TimetableViewModel::class.java)
        _binding = FragmentTimetableBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTimetable
        timetableViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
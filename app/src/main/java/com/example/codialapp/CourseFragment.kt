package com.example.codialapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codialapp.databinding.FragmentCourseBinding
import com.example.codialapp.utils.CreateCourses
import com.example.codialapp.utils.MyObject.booleanAddCourses
import com.example.codialapp.utils.MyObject.tvAllCourseNames
import com.example.codialapp.utils.ReadCourses

class CourseFragment : Fragment() {
    lateinit var createCourses: CreateCourses
    private lateinit var readCourses: ReadCourses
    lateinit var binding: FragmentCourseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        showWindow()
        setOnClick()
        return binding.root
    }

    private fun loadData() {
        binding = FragmentCourseBinding.inflate(layoutInflater)
        createCourses = CreateCourses(requireActivity(), binding, findNavController())
        readCourses = ReadCourses(requireActivity(), binding, findNavController())
    }

    private fun showWindow() {
        binding.tvAllCourses.text = tvAllCourseNames
        if (booleanAddCourses) {
            binding.imageAdd.visibility = View.VISIBLE
            binding.lyAdd.visibility = View.VISIBLE
        }
        requireActivity().window.statusBarColor = Color.parseColor("#c78800")
        readCourses.readCourses()
    }

    private fun setOnClick() {
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.lyAdd.setOnClickListener {
            createCourses.buildDialog()
        }
    }
}
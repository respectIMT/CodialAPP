package com.example.codialapp.utils

import android.app.Activity
import androidx.navigation.NavController
import com.example.codialapp.adapters.CoursesAdapter
import com.example.codialapp.databinding.FragmentCourseBinding
import com.example.codialapp.db.MyDBHelper
import com.example.codialapp.models.Courses

class ReadCourses(
    private val activity: Activity,
    private val binding: FragmentCourseBinding,
    val findNavController: NavController
) {
    private lateinit var arrayListCourses: ArrayList<Courses>
    private lateinit var coursesAdapter: CoursesAdapter
    private lateinit var myDBHelper: MyDBHelper

    fun readCourses() {
        loadData()
        coursesAdapter = CoursesAdapter(arrayListCourses, object : CoursesAdapter.RVClickCourses {
            override fun onClick(courses: Courses) {
                MyObject.courses = courses
                findNavController.navigate(MyObject.navigationID)
            }
        })
        binding.recyclerCourses.adapter = coursesAdapter
    }

    private fun loadData() {
        arrayListCourses = ArrayList()
        myDBHelper = MyDBHelper(activity)
        arrayListCourses = myDBHelper.readCourses()
    }
}
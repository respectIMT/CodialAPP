package com.example.codialapp.db

import android.content.Context
import com.example.codialapp.models.Courses
import com.example.codialapp.models.Groups
import com.example.codialapp.models.Mentors
import com.example.codialapp.models.Students

interface MyDBInterface {
    //Course Interface
    fun createCourses(courses: Courses, context: Context): Boolean
    fun readCourses(): ArrayList<Courses>
    fun deleteCourses(courses: Courses): Boolean
    fun getCoursesByID(id: Int): Courses

    //Mentors Interface
    fun createMentors(mentors: Mentors, context: Context)
    fun readMentors(): ArrayList<Mentors>
    fun updateMentors(mentors: Mentors, context: Context)
    fun deleteMentors(mentors: Mentors): Boolean
    fun getMentorsByID(id: Int): Mentors
    fun getMentorByCoursesID(courses: Courses)
    fun getAllMentorsByID(id: Int): ArrayList<Mentors>

    //Groups Interface
    fun createGroups(groups: Groups, context: Context): Boolean
    fun readGroups(string: String, context: Context): ArrayList<Groups>
    fun updateGroups(groups: Groups, context: Context)
    fun deleteGroups(groups: Groups): Boolean
    fun getGroupsByMentorsID(mentors: Mentors)
    fun getGroupsByID(id: Int, boolean: Boolean): Groups
    fun startLessonGroup(groups: Groups, context: Context): Boolean

    //Students Interface
    fun createStudents(students: Students, context: Context)
    fun readStudents(id: Int, boolean: Boolean): ArrayList<Students>
    fun updateStudents(students: Students, context: Context)
    fun deleteStudents(students: Students): Boolean
    fun getStudentByGroupsID(groups: Groups)
}
package com.example.codialapp.utils

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import com.example.codialapp.R
import com.example.codialapp.databinding.DialogAddCoursesBinding
import com.example.codialapp.databinding.FragmentCourseBinding
import com.example.codialapp.db.MyDBHelper
import com.example.codialapp.models.Courses

class CreateCourses(
    var activity: Activity,
    var binding: FragmentCourseBinding,
    var findNavController: NavController
) {

    private lateinit var bindingDialog: DialogAddCoursesBinding
    lateinit var dialog: AlertDialog
    lateinit var myDBHelper: MyDBHelper
    lateinit var readCourses: ReadCourses
    var booleanAntiBug =
        true

    fun buildDialog() {
        bindingDialog = DialogAddCoursesBinding.inflate(activity.layoutInflater)
        var alertDialog = AlertDialog.Builder(activity)
        bindingDialog.tvCancel.setOnClickListener {
            dialog.cancel()
        }

        bindingDialog.tvSave.setOnClickListener {
            val name = bindingDialog.edtCoursesName.text.toString().trim()
            val description = bindingDialog.edtCoursesAbout.text.toString().trim()
            if (name.isNotEmpty() && description.isNotEmpty()) {
                myDBHelper = MyDBHelper(activity)
                if (myDBHelper.createCourses(Courses(name, description), activity)) {
                    readCourses = ReadCourses(activity, binding, findNavController)
                    readCourses.readCourses()
                    dialog.cancel()
                }
            }
        }
        alertDialog.setOnCancelListener {
            booleanAntiBug = true
        }
        alertDialog.setView(bindingDialog.root)
        dialog = alertDialog.create()
        dialog.window!!.attributes.windowAnimations = R.style.MyAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (booleanAntiBug) {
            dialog.show()
            booleanAntiBug = false
        }
    }
}
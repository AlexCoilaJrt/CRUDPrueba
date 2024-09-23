package com.mkiperszmid.emptyapp.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class StudentViewModel(
    private val studentService: StudentService
) : ViewModel() {
    var state by mutableStateOf(StudentState())
        private set

    init {
        getStudents()
    }

    private fun getStudents() {
        viewModelScope.launch {
            try {
                val students = studentService.getStudents()
                state = state.copy(
                    students = students
                )
            } catch (e: Exception) {
                // Manejo de errores
            }
        }
    }

    fun changeName(name: String) {
        state = state.copy(
            studentName = name
        )
    }

    fun changeGrade(grade: String) {
        state = state.copy(
            studentGrade = grade
        )
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            try {
                studentService.deleteStudent(student.id)
            } catch (e: Exception) {
                // Manejo de errores
            }
            getStudents()
        }
    }

    fun editStudent(student: Student) {
        state = state.copy(
            studentName = student.name,
            studentGrade = student.grade,
            studentId = student.id
        )
    }

    fun createStudent() {
        val student = StudentDto(
            state.studentName,
            state.studentGrade
        )
        viewModelScope.launch {
            try {
                if (state.studentId == null) {
                    studentService.insertStudent(student)
                } else {
                    studentService.updateStudent(student, state.studentId!!)
                }
            } catch (e: Exception) {
                // Manejo de errores
            }
            getStudents()
        }
        state = state.copy(
            studentName = "",
            studentGrade = "",
            studentId = null
        )
    }
}
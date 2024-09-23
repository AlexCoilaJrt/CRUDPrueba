package com.mkiperszmid.emptyapp.home

data class StudentState(
    val students: List<Student> = emptyList(), // Lista de estudiantes
    val studentName: String = "", // Nombre del estudiante
    val studentGrade: String = "", // Grado del estudiante
    val studentId: String? = null // ID del estudiante (para editar)
)
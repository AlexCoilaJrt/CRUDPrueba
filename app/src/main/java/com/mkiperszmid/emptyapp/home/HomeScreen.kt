package com.mkiperszmid.emptyapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    viewModel: StudentViewModel
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Mis Estudiantes", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

        // Campo para el nombre del estudiante
        TextField(
            value = state.studentName,
            onValueChange = { viewModel.changeName(it) },
            placeholder = { Text(text = "Nombre del estudiante") }
        )

        // Campo para el grado del estudiante
        TextField(
            value = state.studentGrade,
            onValueChange = { viewModel.changeGrade(it) },
            placeholder = { Text(text = "Grado") }
        )

        // Botón para agregar estudiante
        Button(onClick = { viewModel.createStudent() }) {
            Text(text = "Agregar Estudiante")
        }

        // Lista de estudiantes
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.students) { student ->
                StudentItem(student = student, modifier = Modifier.fillMaxWidth(), onEdit = {
                    viewModel.editStudent(student)
                }, onDelete = {
                    viewModel.deleteStudent(student)
                })
            }
        }
    }
}

package com.mkiperszmid.emptyapp.home

import com.squareup.moshi.Json

data class Student(
    @field:Json(name = "_id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "grade")
    val grade: String
)

data class StudentDto(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "grade")
    val grade: String
)
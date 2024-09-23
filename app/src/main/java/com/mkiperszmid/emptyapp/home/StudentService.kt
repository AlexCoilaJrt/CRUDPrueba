package com.mkiperszmid.emptyapp.home

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface StudentService {
    companion object {
        val instance: StudentService =
            Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/c4f7d4700f6044f686c7b7bf5f515a8c/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
                .create(StudentService::class.java)
    }

    @GET("students")
    suspend fun getStudents(): List<Student>

    @POST("students")
    suspend fun insertStudent(@Body student: StudentDto): Student

    @PUT("students/{id}")
    suspend fun updateStudent(@Body student: StudentDto, @Path("id") id: String)

    @DELETE("students/{id}")
    suspend fun deleteStudent(@Path("id") id: String)
}

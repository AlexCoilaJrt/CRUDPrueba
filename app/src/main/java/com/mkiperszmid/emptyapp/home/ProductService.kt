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

interface ProductService {
    companion object {
        val instance =
            Retrofit.Builder().baseUrl("https://crudcrud.com/api/c4f7d4700f6044f686c7b7bf5f515a8c/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build().create(ProductService::class.java)
    }

    @GET("products")
    suspend fun getProducts(): List<Product>

    @POST("products")
    suspend fun insertProduct(@Body product: ProductDto): Product

    @PUT("products/{id}")
    suspend fun updateProduct(@Body product: ProductDto, @Path("id") id: String)

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id: String)
}

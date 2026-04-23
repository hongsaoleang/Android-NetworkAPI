package com.example.networkingapi.services

import com.example.networkingapi.model.ModelPost
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getMyPost(): List<ModelPost>
}

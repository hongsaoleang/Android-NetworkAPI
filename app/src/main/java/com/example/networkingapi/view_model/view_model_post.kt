package com.example.networkingapi.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingapi.model.ModelPost
import com.example.networkingapi.services.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModelPost : ViewModel() {
    private val _posts = mutableStateOf<List<ModelPost>>(emptyList())
    val posts: State<List<ModelPost>> = _posts

    private val api = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    init {
        fetchPost()
    }

    private fun fetchPost() {
        viewModelScope.launch {
            try {
                _posts.value = api.getMyPost()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

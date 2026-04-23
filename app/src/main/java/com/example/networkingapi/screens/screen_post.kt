package com.example.networkingapi.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.networkingapi.model.ModelPost
import com.example.networkingapi.view_model.ViewModelPost

@Composable
fun ScreenPost(viewModel: ViewModelPost = viewModel()){
    val posts = viewModel.posts.value
    Scaffold(
        topBar = {

        }
    ) {
        padding->
        LazyColumn(contentPadding = padding){
            items(posts){
                post ->PostCard(post)
            }
        }
    }
}
@Composable
fun PostCard(post: ModelPost){
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = post.title , style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = post.body , style = MaterialTheme.typography.bodySmall)
        }
    }
}
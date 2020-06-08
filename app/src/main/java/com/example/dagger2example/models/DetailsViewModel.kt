package com.example.dagger2example.models

import com.google.gson.Gson

data class DetailsViewModel(val posts: List<PostViewModel>, val users: List<UserViewModel>, val albums: List<AlbumViewModel>) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
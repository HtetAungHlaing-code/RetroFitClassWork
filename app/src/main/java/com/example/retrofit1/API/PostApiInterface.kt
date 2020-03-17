package com.example.retrofit1.API

import com.example.retrofit1.Model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostApiInterface {
    @GET("posts")
    fun getPost(): Call<List<Post>>
}
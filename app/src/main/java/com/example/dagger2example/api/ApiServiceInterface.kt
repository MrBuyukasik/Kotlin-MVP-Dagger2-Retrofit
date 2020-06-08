package com.example.dagger2example.api

import com.example.dagger2example.models.Album
import com.example.dagger2example.models.Post
import com.example.dagger2example.models.User
import com.example.dagger2example.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    @GET("albums")
    fun getAlbumList(): Observable<List<Album>>

    @GET("albums/{id}")
    fun getAlbum(@Path("id") id: Int): Observable<Album>

    @GET("posts")
    fun getPostList(): Observable<List<Post>>

    @GET("post/{id}")
    fun getPost(@Path("id") id: Int): Observable<Post>

    @GET("users")
    fun getUserList(): Observable<List<User>>


    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}
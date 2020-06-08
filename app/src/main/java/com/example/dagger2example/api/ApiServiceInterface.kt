package com.example.dagger2example.api

import com.example.dagger2example.models.AlbumViewModel
import com.example.dagger2example.models.PostViewModel
import com.example.dagger2example.models.UserViewModel
import com.example.dagger2example.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    @GET("albums")
    fun getAlbumList(): Observable<List<AlbumViewModel>>

    @GET("albums/{id}")
    fun getAlbum(@Path("id") id: Int): Observable<AlbumViewModel>

    @GET("posts")
    fun getPostList(): Observable<List<PostViewModel>>

    @GET("post/{id}")
    fun getPost(@Path("id") id: Int): Observable<PostViewModel>

    @GET("users")
    fun getUserList(): Observable<List<UserViewModel>>


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
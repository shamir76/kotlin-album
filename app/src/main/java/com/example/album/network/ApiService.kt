package com.example.album.network

import com.example.album.model.Album
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


//https://jsonplaceholder.typicode.com/photos
interface ApiService {
    @GET("photos")
    suspend fun getAlbums() : List<Album>

    companion object {
        var apiService : ApiService? = null
        fun getInstance() : ApiService {
            if ( apiService == null ) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create()
            }
            return  apiService!!
        }
    }

}
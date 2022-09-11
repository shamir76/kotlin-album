package com.example.album.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.album.model.Album
import com.example.album.network.ApiService
import kotlinx.coroutines.launch
import java.lang.Exception

class AlbumViewModel : ViewModel(){

    var result : List<Album> by mutableStateOf(listOf())
    var errorMessage : String by mutableStateOf("")

    fun getAlbumList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val albumList = apiService.getAlbums()
                result = albumList
            } catch ( e: Exception ) {
                errorMessage = e.message.toString()
            }
        }
    }


}
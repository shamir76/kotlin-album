package com.example.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.album.model.Album
import com.example.album.viewModel.AlbumViewModel

class MainActivity : AppCompatActivity() {
    val albumViewModel by viewModels<AlbumViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
           Surface(color = MaterialTheme.colors.background) {
               DisplayAlbums(album = albumViewModel.result)
               albumViewModel.getAlbumList()
           }
       }
    }
}

@Composable
fun DisplayAlbums( album: List<Album>){
    LazyColumn() {
        itemsIndexed(items = album) {_, item->
            AlbumItem(album = item)
        }
    }
}
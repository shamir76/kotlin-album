package com.example.album

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.album.model.Album

@Composable
fun AlbumItem(album: Album) {

    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp) {

        Surface {
            Row(modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()) {
                AsyncImage(
                    model = album.thumbnailUrl,
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight()
                )
                Column(
                    verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
                    .weight(0.8f)) {
                    Text(text = album.title,
                        style = MaterialTheme.typography.caption,
                        fontSize = 18.sp,
                        modifier = Modifier
                        .padding(4.dp))
                    Button(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        onClick = { }
                    ) {
                        Text(text = "Visit profile")
                        
                    }
                }
            }
        }

    }
}
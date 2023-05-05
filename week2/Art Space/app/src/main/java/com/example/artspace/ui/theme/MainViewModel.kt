package com.example.artspace.ui.theme

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.artspace.R
import com.example.artspace.data.Gallery

class MainViewModel:ViewModel() {
    private val galleryData: List<Gallery> = listOf(
        Gallery(
            R.drawable.girl_with_pearl,
            R.string.girl_pearl_title,
            R.string.girl_pearl_artist
        ),
        Gallery(
            R.drawable.mona_lisa,
            R.string.mona_lisa_title,
            R.string.mona_lisa_artist
        ),
        Gallery(
            R.drawable.memory,
            R.string.memory_title,
            R.string.memory_artist
        ),
        Gallery(
            R.drawable.scream,
            R.string.scream_title,
            R.string.scream_artist
        )
    )

    fun getGalleryData(): List<Gallery> = galleryData
}
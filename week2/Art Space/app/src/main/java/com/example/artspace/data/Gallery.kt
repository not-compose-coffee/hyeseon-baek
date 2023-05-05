package com.example.artspace.data

import androidx.annotation.DrawableRes

data class Gallery(
    @DrawableRes
    val artImageResource: Int,
    val title: String,
    val artistName: String,
)

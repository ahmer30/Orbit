package com.example.orbit

import androidx.annotation.DrawableRes

data class Category(
    val id: Int,
    val name: String,
    @DrawableRes val icon: Int
)
package com.example.footballapp.model

import java.io.Serializable

data class League(
    val image: Int,
    val name: String,
    val country: String,
    val clubs: MutableList<Club>
): Serializable

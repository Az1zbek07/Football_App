package com.example.footballapp.util

import com.example.footballapp.R
import com.example.footballapp.model.Club
import com.example.footballapp.model.League

object Constants {
    fun clubsLaLiga(): MutableList<Club>{
        return arrayListOf(
           Club(R.drawable.img_2, "Atletico Madrid", 2, 1, 6, 23, 38),
           Club(R.drawable.img_3, "Real Madrid", 4, 3, 7, 15, 37),
           Club(R.drawable.img_6, "Barcelona", 4, 4, 9, 20, 34),
           Club(R.drawable.img_5, "Villareal", 8, 2, 10, 16, 32)
        )
    }

    fun clubsPremierLeague(): MutableList<Club>{
        return arrayListOf(
            Club(R.drawable.img_7, "Liverpool", 6, 2, 21, 16, 33),
            Club(R.drawable.img_8, "Man United", 3, 3, 24, 9, 33),
            Club(R.drawable.img_4, "Leicester City", 2, 5, 21, 10, 32),
            Club(R.drawable.img_5, "Villareal", 8, 2, 10, 16, 32)
        )
    }

    fun leagues(): MutableList<League>{
        return arrayListOf(
            League(R.drawable.img, "La Liga", "Spain", clubsLaLiga()),
            League(R.drawable.img_1, "Premier League", "England", clubsPremierLeague()),
            League(R.drawable.img, "La Liga", "Spain", clubsLaLiga()),
            League(R.drawable.img_1, "Premier League", "England", clubsPremierLeague())
        )
    }
}
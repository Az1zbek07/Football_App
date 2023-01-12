package com.example.footballapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.R
import com.example.footballapp.adapter.ClubAdapter
import com.example.footballapp.model.League
import com.example.footballapp.util.Constants

class ClubListFragment : Fragment() {
    private lateinit var clubAdapter: ClubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clubAdapter = ClubAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_club_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val league = arguments?.getSerializable("league") as League
        view.apply {
            findViewById<ImageView>(R.id.leagueImage).setImageResource(league.image)
            findViewById<TextView>(R.id.leagueName).text = league.name
            findViewById<RecyclerView>(R.id.rvClubList).adapter = clubAdapter
        }
        if (league.name == "La Liga"){
            clubAdapter.submitList(Constants.clubsLaLiga())
        }else{
            clubAdapter.submitList(Constants.clubsPremierLeague())
        }
    }
}
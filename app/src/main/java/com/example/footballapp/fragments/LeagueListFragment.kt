package com.example.footballapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.R
import com.example.footballapp.adapter.LeagueAdapter
import com.example.footballapp.model.League
import com.example.footballapp.util.Constants

class LeagueListFragment : Fragment() {
    private lateinit var leagueAdapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leagueAdapter = LeagueAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.rvLeagueList).adapter = leagueAdapter
        leagueAdapter.submitList(Constants.leagues())
        leagueAdapter.onClick = {
            val bundle = bundleOf("league" to it)
            findNavController().navigate(R.id.action_leagueListFragment_to_clubListFragment, bundle)
        }
    }
}
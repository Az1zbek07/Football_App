package com.example.footballapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.databinding.LeagueItemLayoutBinding
import com.example.footballapp.model.League
import com.example.footballapp.util.Constants

class LeagueAdapter(): ListAdapter<League, LeagueAdapter.VHolder>(DiffCallBack()) {
    lateinit var onClick: (league: League) -> Unit
    private class DiffCallBack: DiffUtil.ItemCallback<League>(){
        override fun areItemsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(LeagueItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VHolder(private val binding: LeagueItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(league: League){
            binding.itemLeagueCountry.text = league.country
            binding.itemLeagueImage.setImageResource(league.image)
            binding.itemLeagueName.text = league.name
            val adapterClub = ClubAdapter()
            binding.rvItemLayout.adapter = adapterClub
            if (league.name == "La Liga"){
                adapterClub.submitList(Constants.clubsLaLiga())
            }else{
                adapterClub.submitList(Constants.clubsPremierLeague())
            }
            binding.itemLeagueBtn.setOnClickListener {
                onClick.invoke(league)
            }
        }
    }
}
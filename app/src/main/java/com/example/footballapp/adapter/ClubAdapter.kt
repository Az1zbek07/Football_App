package com.example.footballapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.databinding.ClubItemLayoutBinding
import com.example.footballapp.model.Club

class ClubAdapter: ListAdapter<Club, ClubAdapter.ViewHolder>(DiffCallBack()) {
    private class DiffCallBack(): DiffUtil.ItemCallback<Club>() {
        override fun areItemsTheSame(oldItem: Club, newItem: Club): Boolean {
            return newItem.name == oldItem.name
        }

        override fun areContentsTheSame(oldItem: Club, newItem: Club): Boolean {
            return newItem == oldItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ClubItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ClubItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(club: Club){
            binding.apply {
                itemClubImage.setImageResource(club.image)
                itemClubName.text = club.name
                number1.text = club.num1.toString()
                number2.text = club.num2.toString()
                number3.text = club.num3.toString()
                number4.text = club.num4.toString()
                number5.text = club.num5.toString()
            }
        }
    }
}
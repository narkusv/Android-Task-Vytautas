package com.example.appfornewdevs.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appfornewdevs.databinding.ItemRegionBinding
import com.example.appfornewdevs.models.RegionModel

class RegionAdapter :
    ListAdapter<RegionModel, RegionAdapter.ViewHolder>(RegionDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ItemRegionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RegionModel) {
            binding.regionModel = item
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRegionBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class RegionDiffCallback : DiffUtil.ItemCallback<RegionModel>() {
    override fun areItemsTheSame(
        oldItem: RegionModel,
        newItem: RegionModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: RegionModel,
        newItem: RegionModel
    ): Boolean {
        return oldItem.name == newItem.name && oldItem.population == newItem.population
    }
}
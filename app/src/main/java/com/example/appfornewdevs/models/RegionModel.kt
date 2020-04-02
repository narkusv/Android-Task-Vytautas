package com.example.appfornewdevs.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class RegionModel(
    @Bindable
    val name: String,
    @Bindable
    val population: Long
): BaseObservable(), Comparable<RegionModel>{

    override fun compareTo(other: RegionModel): Int {
        return (population.minus(other.population)).toInt()
    }

}
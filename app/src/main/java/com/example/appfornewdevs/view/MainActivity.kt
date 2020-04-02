package com.example.appfornewdevs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfornewdevs.R
import com.example.appfornewdevs.databinding.ActivityMainBinding
import com.example.appfornewdevs.models.RegionModel
import com.example.appfornewdevs.viewmodels.BaseViewModelFactory
import com.example.appfornewdevs.viewmodels.MainActivityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            BaseViewModelFactory.viewModelFactory { MainActivityViewModel(this.application) }
        ).get(MainActivityViewModel::class.java)

        //TODO get regions from viewModel and add to view


    }



}

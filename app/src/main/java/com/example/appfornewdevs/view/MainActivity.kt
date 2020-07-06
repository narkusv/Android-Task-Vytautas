package com.example.appfornewdevs.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appfornewdevs.R
import com.example.appfornewdevs.databinding.ActivityMainBinding
import com.example.appfornewdevs.viewmodels.BaseViewModelFactory
import com.example.appfornewdevs.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.regionsList.adapter = RegionAdapter()

        viewModel = ViewModelProvider(
            this,
            BaseViewModelFactory.viewModelFactory { MainActivityViewModel(this.application) }
        ).get(MainActivityViewModel::class.java)

        observeErrors()
        observeRegions()
    }

    private fun observeErrors() {
        viewModel.onFailedToFetchRegions.observe(this, Observer {
            Toast.makeText(this, R.string.error_generic_error, Toast.LENGTH_SHORT).show()
        })
    }

    private fun observeRegions() {
        viewModel.regions.observe(this, Observer {
            (regionsList.adapter as RegionAdapter).submitList(it)
        })
    }
}

package com.example.appfornewdevs.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.appfornewdevs.MainApplication
import com.example.appfornewdevs.models.RegionModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private fun getApiServices() = getApplication<MainApplication>().appServices

    //TODO get regions from api


}
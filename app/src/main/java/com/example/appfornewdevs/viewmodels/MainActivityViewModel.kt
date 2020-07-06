package com.example.appfornewdevs.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.appfornewdevs.MainApplication
import com.example.appfornewdevs.core.Event
import com.example.appfornewdevs.models.RegionModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private const val REGION_EUROPE = "Europe"
private const val TAG = "MainActivityViewModel"

@SuppressLint("CheckResult")
class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private fun getApiServices() = getApplication<MainApplication>().appServices

    val regions = MutableLiveData<List<RegionModel>>()
    val onFailedToFetchRegions = MutableLiveData<Event<Throwable>>()

    init {
        try {
            getApiServices().getEuropeRegions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (!it.isNullOrEmpty()) {
                        regions.value =
                            it.filter { it.region == REGION_EUROPE }.sortedBy { it.name }
                    } else {
                        onFailedToFetchRegions.value = Event(Exception("Failed to get events"))
                    }
                }, {
                    Log.e(TAG, Log.getStackTraceString(it))
                    onFailedToFetchRegions.value = Event(it)
                })
        } catch (ex: Exception) {
            Log.e(TAG, Log.getStackTraceString(ex))
            onFailedToFetchRegions.value = Event(ex)
        }
    }
}
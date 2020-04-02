package com.example.appfornewdevs.api

import com.example.appfornewdevs.models.RegionModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiServices {

    @GET("region/europe")
    fun getEuropeRegions(): Observable<List<RegionModel>>


}
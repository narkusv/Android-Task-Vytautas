package com.example.appfornewdevs

import android.app.Application
import com.example.appfornewdevs.api.ApiClient
import com.example.appfornewdevs.api.ApiServices

class MainApplication: Application() {

    open val appServices: ApiServices by lazy {
        ApiClient.getAppServices(this)
    }

}
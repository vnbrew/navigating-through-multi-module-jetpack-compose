package com.module.jetpack.compose.app

import android.app.Application
import com.module.jetpack.compose.app.di.AppProvider
import com.module.jetpack.compose.app.di.DaggerAppComponent
import com.module.jetpack.compose.common.di.DaggerCommonComponent
import com.module.jetpack.compose.data.impl.di.DaggerDataComponent

class MainApplication : Application() {

    lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()

        val commonProvider = DaggerCommonComponent.factory().create(this)
        appProvider = DaggerAppComponent.builder()
            .commonProvider(commonProvider)
            .dataProvider(DaggerDataComponent.builder().commonProvider(commonProvider).build())
            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as MainApplication).appProvider
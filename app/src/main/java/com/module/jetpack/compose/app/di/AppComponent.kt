package com.module.jetpack.compose.app.di

import com.module.jetpack.compose.common.di.CommonProvider
import com.module.jetpack.compose.data.api.DataProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CommonProvider::class,
        DataProvider::class,
    ],
    modules = [NavigationModule::class]
)
interface AppComponent : AppProvider
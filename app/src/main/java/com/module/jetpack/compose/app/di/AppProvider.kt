package com.module.jetpack.compose.app.di

import androidx.compose.runtime.compositionLocalOf
import com.module.jetpack.compose.common.Destinations
import com.module.jetpack.compose.common.di.CommonProvider
import com.module.jetpack.compose.data.api.DataProvider


interface AppProvider : DataProvider, CommonProvider {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
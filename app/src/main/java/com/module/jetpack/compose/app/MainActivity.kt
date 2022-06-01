package com.module.jetpack.compose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import com.module.jetpack.compose.app.di.LocalAppProvider
import com.module.jetpack.compose.common.di.LocalCommonProvider
import com.module.jetpack.compose.common.ui.NavigationBar
import com.module.jetpack.compose.common.ui.StatusBar
import com.module.jetpack.compose.common.ui.theme.AppBlack
import com.module.jetpack.compose.common.ui.theme.ComposeArchTheme
import com.module.jetpack.compose.data.api.LocalDataProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeArchTheme {
                StatusBar(window, color = MaterialTheme.colors.background)

                Surface(color = MaterialTheme.colors.background) {
                    CompositionLocalProvider(
                        LocalAppProvider provides application.appProvider,
                        LocalDataProvider provides application.appProvider,
                        LocalCommonProvider provides application.appProvider
                    ) {
                        Navigation()
                    }
                }

                NavigationBar(window, color = AppBlack)
            }
        }
    }
}
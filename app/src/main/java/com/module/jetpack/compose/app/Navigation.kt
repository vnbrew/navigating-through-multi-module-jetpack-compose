package com.module.jetpack.compose.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.module.jetpack.compose.app.di.LocalAppProvider
import com.module.jetpack.compose.app.ui.BottomMenuBar
import com.module.jetpack.compose.common.find
import com.module.jetpack.compose.home.api.HomeEntry
import com.module.jetpack.compose.timetable.api.TimetableEntry

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val homeScreen = destinations.find<HomeEntry>()
    val timetableScreen = destinations.find<TimetableEntry>()

    Box(Modifier.fillMaxSize()) {
        NavHost(navController, startDestination = homeScreen.destination()) {
            with(homeScreen) {
                composable(navController, destinations)
            }
            with(timetableScreen) {
                composable(navController, destinations)
            }
        }
    }

    Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
        BottomMenuBar(navController, destinations)
    }
}
package com.module.jetpack.compose.app

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.module.jetpack.compose.app.di.LocalAppProvider
import com.module.jetpack.compose.app.ui.BottomNavigationBar
import com.module.jetpack.compose.app.ui.TabDirections
import com.module.jetpack.compose.common.find
import com.module.jetpack.compose.home.api.HomeEntry
import com.module.jetpack.compose.timetable.api.TimetableEntry

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val homeScreen = destinations.find<HomeEntry>()
    val timetableScreen = destinations.find<TimetableEntry>()

    val tabDirections = listOf(
        TabDirections(homeScreen.destination(), R.drawable.ic_home, "Home"),
        TabDirections(timetableScreen.destination(), R.drawable.ic_table, "Table")
    )

    val startDestination = homeScreen.destination()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, tabDirections, startDestination) }
    ) {
        NavHost(navController, startDestination = startDestination) {
            with(homeScreen) {
                composable(navController, destinations)
            }
            with(timetableScreen) {
                composable(navController, destinations)
            }
        }
    }
}
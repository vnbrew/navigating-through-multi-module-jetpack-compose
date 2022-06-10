package com.module.jetpack.compose.app

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.module.jetpack.compose.app.di.LocalAppProvider
import com.module.jetpack.compose.app.ui.BottomNavigationBar
import com.module.jetpack.compose.app.ui.TabDirections
import com.module.jetpack.compose.common.Destinations
import com.module.jetpack.compose.common.find
import com.module.jetpack.compose.detail.api.DetailEntry
import com.module.jetpack.compose.home.api.HomeEntry
import com.module.jetpack.compose.timetable.api.TimetableEntry

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val destinations = LocalAppProvider.current.destinations
    val homeScreen = destinations.find<HomeEntry>()
    val timetableScreen = destinations.find<TimetableEntry>()
    val tabDirections = listOf(
        TabDirections(homeScreen.route(), R.drawable.ic_home, "Home"),
        TabDirections(timetableScreen.route(), R.drawable.ic_table, "Table")
    )
    val defaultRoute = homeScreen.route()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, tabDirections, defaultRoute) }
    ) {
        NavHost(navController = navController,
            startDestination = defaultRoute) {
            navigation(
                route = homeScreen.route(),
                startDestination = homeScreen.startDestination(),
            ) {
                addHomeGraph(navController, destinations)
            }

            navigation(
                route = timetableScreen.route(),
                startDestination = timetableScreen.startDestination(),
            ) {
                addTimetableGraph(navController, destinations)
            }
        }
    }
}

fun NavGraphBuilder.addHomeGraph(
    navController: NavHostController,
    destinations: Destinations,
) {
    val homeScreen = destinations.find<HomeEntry>()
    val detailScreen = destinations.find<DetailEntry>()
    with(homeScreen) {
        composable(homeScreen.startDestination(), navController, destinations)
    }
    with(detailScreen) {
        composable(detailScreen.startDestinationInParent(homeScreen.startDestination()),
            navController,
            destinations)
    }
}

fun NavGraphBuilder.addTimetableGraph(
    navController: NavHostController,
    destinations: Destinations,
) {
    val timetableScreen = destinations.find<TimetableEntry>()
    val detailScreen = destinations.find<DetailEntry>()
    with(timetableScreen) {
        composable(timetableScreen.startDestination(), navController, destinations)
    }
    with(detailScreen) {
        composable(detailScreen.startDestinationInParent(timetableScreen.startDestination()),
            navController,
            destinations)
    }
}
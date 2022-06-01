package com.module.jetpack.compose.app.di

import com.module.jetpack.compose.home.impl.di.HomeEntryModule
import com.module.jetpack.compose.timetable.impl.di.TimetableEntryModule
import dagger.Module

@Module(
    includes = [
        HomeEntryModule::class,
        TimetableEntryModule::class
    ]
)
interface NavigationModule
package com.module.jetpack.compose.app.di

import com.module.jetpack.compose.detail.impl.di.DetailEntryModule
import com.module.jetpack.compose.home.impl.di.HomeEntryModule
import com.module.jetpack.compose.login.impl.di.LoginEntryModule
import com.module.jetpack.compose.timetable.impl.di.TimetableEntryModule
import dagger.Module

@Module(
    includes = [
        HomeEntryModule::class,
        TimetableEntryModule::class,
        DetailEntryModule::class,
        LoginEntryModule::class
    ]
)
interface NavigationModule
package com.example.dagger2example.di.component

import com.example.dagger2example.di.module.ActivityModule
import com.example.dagger2example.ui.main.MainActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}
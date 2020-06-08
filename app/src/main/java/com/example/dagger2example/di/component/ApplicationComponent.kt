package com.example.dagger2example.di.component

import com.example.dagger2example.BaseApp
import com.example.dagger2example.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: BaseApp)
}
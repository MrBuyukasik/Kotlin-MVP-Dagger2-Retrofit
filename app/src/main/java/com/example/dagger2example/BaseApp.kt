package com.example.dagger2example

import android.app.Application
import com.example.dagger2example.di.component.ApplicationComponent
import com.example.dagger2example.di.component.DaggerApplicationComponent
import com.example.dagger2example.di.module.ApplicationModule
import okhttp3.internal.Internal.instance

class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}
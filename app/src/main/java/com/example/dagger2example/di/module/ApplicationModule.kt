package com.example.dagger2example.di.module

import android.app.Application
import com.example.dagger2example.BaseApp
import com.example.dagger2example.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}
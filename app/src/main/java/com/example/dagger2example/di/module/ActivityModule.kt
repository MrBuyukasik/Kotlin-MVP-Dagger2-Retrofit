package com.example.dagger2example.di.module

import android.app.Activity
import com.example.dagger2example.ui.main.MainContract
import com.example.dagger2example.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter{
        return MainPresenter()
    }
}
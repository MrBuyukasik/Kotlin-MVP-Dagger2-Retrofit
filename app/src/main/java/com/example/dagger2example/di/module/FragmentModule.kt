package com.example.dagger2example.di.module

import com.example.dagger2example.api.ApiServiceInterface
import com.example.dagger2example.ui.about.AboutContract
import com.example.dagger2example.ui.about.AboutPresenter
import com.example.dagger2example.ui.list.ListContract
import com.example.dagger2example.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideAboutPresenter(): AboutContract.Presenter {
        return AboutPresenter()
    }

    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}
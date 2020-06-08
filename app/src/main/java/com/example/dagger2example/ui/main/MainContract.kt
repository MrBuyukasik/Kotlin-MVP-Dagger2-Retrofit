package com.example.dagger2example.ui.main

import com.example.dagger2example.ui.base.BaseContract

class MainContract {

    interface View : BaseContract.View {
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter : BaseContract.Presenter<MainContract.View> {
        fun onDrawerOptionAboutClick()
    }
}
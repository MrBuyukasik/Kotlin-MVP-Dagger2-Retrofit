package com.example.dagger2example.ui.main

import io.reactivex.disposables.CompositeDisposable

class MainPresenter : MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun subscribe() {}

    override fun unsubscribe() {}

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showListFragment()
    }

    override fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }

}
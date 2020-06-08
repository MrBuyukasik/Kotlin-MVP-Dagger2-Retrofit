package com.example.dagger2example.ui.about

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.android.schedulers.AndroidSchedulers.*
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class AboutPresenter : AboutContract.Presenter {

    private lateinit var view: AboutContract.View

    override fun loadMessage() {

        Observable.just(true).delay(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribe {
                view.showProgress(false)
                view.loadMessageSuccess("Success")
            }
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun attach(view: AboutContract.View) {

    }
}
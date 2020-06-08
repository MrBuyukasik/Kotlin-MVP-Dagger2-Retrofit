package com.example.dagger2example.ui.about

import com.example.dagger2example.ui.base.BaseContract

class AboutContract {

    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun loadMessageSuccess(message: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadMessage()
    }
}
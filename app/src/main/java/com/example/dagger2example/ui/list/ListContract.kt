package com.example.dagger2example.ui.list

import com.example.dagger2example.models.DetailsViewModel
import com.example.dagger2example.models.PostViewModel
import com.example.dagger2example.ui.base.BaseContract


class ListContract {

    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<PostViewModel>)
        fun loadDataAllSuccess(model: DetailsViewModel)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
        fun loadDataAll()
        fun deleteItem(item: PostViewModel)
    }
}
package com.example.dagger2example.ui.list

import com.example.dagger2example.api.ApiServiceInterface
import com.example.dagger2example.models.AlbumViewModel
import com.example.dagger2example.models.DetailsViewModel
import com.example.dagger2example.models.PostViewModel
import com.example.dagger2example.models.UserViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers


class ListPresenter : ListContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: ListContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    override fun loadData() {
        var subscribe = api.getPostList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<PostViewModel>? ->
                view.showProgress(false)
                view.loadDataSuccess(list!!.take(10))
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage("Error")
            })

        subscriptions.add(subscribe)
    }

    override fun loadDataAll() {
        var subscribe = Observable.zip(api.getPostList(), api.getUserList(), api.getAlbumList(),
            Function3<List<PostViewModel>, List<UserViewModel>, List<AlbumViewModel>, DetailsViewModel> { posts, users, albums ->
                createDetailsViewModel(posts, users, albums)
            }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ model: DetailsViewModel? ->
                view.showProgress(false)
                view.loadDataAllSuccess(model!!)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }


    override fun deleteItem(item: PostViewModel) {
    }

    private fun createDetailsViewModel(
        posts: List<PostViewModel>,
        users: List<UserViewModel>,
        albums: List<AlbumViewModel>
    ): DetailsViewModel {
        val postList = posts.take(30)
        val userList = users.take(30)
        val albumList = albums.take(30)
        return DetailsViewModel(postList, userList, albumList)
    }


}
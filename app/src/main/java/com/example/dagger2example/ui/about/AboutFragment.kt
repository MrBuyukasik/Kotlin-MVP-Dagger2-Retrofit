package com.example.dagger2example.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dagger2example.R
import com.example.dagger2example.di.component.DaggerFragmentComponent
import com.example.dagger2example.di.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

class AboutFragment : Fragment(), AboutContract.View {

    @Inject
    lateinit var presenter: AboutContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): AboutFragment {
        return AboutFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_about, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun loadMessageSuccess(message: String) {
        aboutText.text = "test"
        aboutText.visibility = View.VISIBLE
    }

    private fun injectDependency() {
        val aboutComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        aboutComponent.inject(this)
    }

    private fun initView() {
        presenter.loadMessage()
    }

    companion object {
        val TAG: String = "AboutFragment"
    }
}
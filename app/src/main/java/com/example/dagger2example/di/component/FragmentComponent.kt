package com.example.dagger2example.di.component

import com.example.dagger2example.di.module.FragmentModule
import com.example.dagger2example.ui.about.AboutFragment
import com.example.dagger2example.ui.list.ListFragment
import dagger.Component


@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(aboutFragment: AboutFragment)

    fun inject(listFragment: ListFragment)
}
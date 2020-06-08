package com.example.dagger2example.di.scope

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplication
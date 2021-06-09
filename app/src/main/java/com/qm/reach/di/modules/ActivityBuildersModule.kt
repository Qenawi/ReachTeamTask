package com.qm.reach.di.modules


import com.qm.reach.di.modules.FragmentBuildersModule
import com.qm.reach.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
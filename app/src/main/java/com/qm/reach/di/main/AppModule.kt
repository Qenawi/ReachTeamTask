package com.qm.reach.di.main

import com.qm.reach.di.modules.DataBaseModule
import com.qm.reach.di.modules.NetWorkModule
import com.qm.reach.di.modules.ViewModelModule
import dagger.Module

@Suppress("unused")
@Module(includes = [ViewModelModule::class, NetWorkModule::class, DataBaseModule::class])
class AppModule

package com.qm.reach.di.modules

import android.app.Application
import androidx.room.Room
import com.qm.reach.di.dataBase.db_model.ReachDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
  private val dataBaseName = "reachDataBase"

  @Provides
  @Singleton
  fun provideDataBaseInstance(app: Application): ReachDataBase {
    val dp = Room.databaseBuilder(app, ReachDataBase::class.java, dataBaseName).build()
    return dp
  }
}

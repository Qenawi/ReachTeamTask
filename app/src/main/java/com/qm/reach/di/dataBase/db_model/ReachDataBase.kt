package com.qm.reach.di.dataBase.db_model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.qm.reach.di.dataBase.Converters
import com.qm.reach.di.dataBase.dao.main.CategoryDao
import com.qm.reach.di.dataBase.dao.main.OffersDao
import com.qm.reach.ui.fragment.home.model.CategoryRequestModel
import com.qm.reach.ui.fragment.home.model.OffersGamesRequestModel

private const val databaseVersion = 1

@Database(
  entities = [CategoryRequestModel::class, OffersGamesRequestModel::class],
  version = databaseVersion
)

@TypeConverters(Converters::class)
abstract class ReachDataBase : RoomDatabase() {
  abstract fun categoryDao() : CategoryDao
  abstract fun offersDao() : OffersDao
}

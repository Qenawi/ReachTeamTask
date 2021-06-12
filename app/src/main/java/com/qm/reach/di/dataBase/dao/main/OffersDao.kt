package com.qm.reach.di.dataBase.dao.main

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qm.reach.ui.fragment.home.model.OffersGamesRequestModel

@Dao
interface OffersDao {
  @Query("SELECT * FROM offersgamesrequestmodel")
  fun get(): List<OffersGamesRequestModel>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(pdaAppConfig: OffersGamesRequestModel): Long

  @Query("DELETE FROM offersgamesrequestmodel")
  fun nukeTable()
}

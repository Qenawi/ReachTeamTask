package com.qm.reach.di.dataBase.dao.main

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qm.reach.ui.fragment.home.model.CategoryRequestModel

@Dao
interface CategoryDao {
  @Query("SELECT * FROM categoryrequestmodel")
  fun get(): List<CategoryRequestModel>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(pdaAppConfig: CategoryRequestModel): Long

  @Query("DELETE FROM categoryrequestmodel")
  fun nukeTable()
}

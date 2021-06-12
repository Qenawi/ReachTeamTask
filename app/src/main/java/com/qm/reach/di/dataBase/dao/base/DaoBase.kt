package com.qm.reach.di.dataBase.dao.base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface DaoBase<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: List<T>): List<Long>

    @Update
    fun update(obj: T)

    @Update
    fun update(obj: List<T>)
}

package com.qm.reach.di.dataBase.db_model.database_migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// MARK :    Handle Migration
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
                "PRIMARY KEY(`id`))"
        )
    }
}


val MIGRATION_1_3 = object : Migration(2, 3)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
          "CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
            "PRIMARY KEY(`id`))"
        )
    }
}

/*
Room.databaseBuilder(applicationContext, MyDb::class.java, "database-name")
        .addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()
 */

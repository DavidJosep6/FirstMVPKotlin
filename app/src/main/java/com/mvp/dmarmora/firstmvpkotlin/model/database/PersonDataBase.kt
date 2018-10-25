package com.mvp.dmarmora.firstmvpkotlin.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1)
abstract class PersonDataBase: RoomDatabase() {
    abstract fun personDao(): PersonDao
}
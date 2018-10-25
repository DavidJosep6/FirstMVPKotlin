package com.mvp.dmarmora.firstmvpkotlin.model.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import android.arch.persistence.room.Delete


@Dao
interface PersonDao {

    @Query("SELECT * FROM person_table")
    fun getAllPersons(): MutableList<PersonEntity>
    @Insert(onConflict = REPLACE)
    fun insert(person: PersonEntity)
    @Update
    fun update(person: PersonEntity)
    @Delete
    fun delete(person: PersonEntity)
    @Query("DELETE FROM person_table")
    fun deleteAll()
}
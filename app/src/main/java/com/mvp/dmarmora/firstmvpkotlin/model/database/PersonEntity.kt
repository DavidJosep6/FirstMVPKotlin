package com.mvp.dmarmora.firstmvpkotlin.model.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Person_table")
data class PersonEntity (@PrimaryKey val email: String = "",
                         val name: String = "",
                         val photo: String = "",
                         val location: String = ""
)
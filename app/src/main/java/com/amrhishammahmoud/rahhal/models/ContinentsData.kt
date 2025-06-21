package com.amrhishammahmoud.rahhal.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


//for continents
@kotlinx.parcelize.Parcelize
@Entity(tableName = "continents_table")
data class ContinentsData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var nameContinent: String,
    var mapBackgroundContinent:Int,
): Parcelable




package com.amrhishammahmoud.rahhal.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

//for continents
@kotlinx.parcelize.Parcelize
@Entity(tableName = "famous_table")
data class FamousData(
    @PrimaryKey(autoGenerate = false)
    var famousImage: Int,
    var famousCountry: String,
    var famousCity:String,
    var famousName: String
): Parcelable


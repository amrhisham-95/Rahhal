package com.amrhishammahmoud.rahhal.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


//for continents
@kotlinx.parcelize.Parcelize
@Entity(tableName = "pictures_table")
data class PicturesData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var flag : String
): Parcelable


package com.amrhishammahmoud.rahhal.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


//for login and signup
@Parcelize
@Entity(tableName = "users_table")
data class Users(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var email: String,
    var password:String
) : Parcelable
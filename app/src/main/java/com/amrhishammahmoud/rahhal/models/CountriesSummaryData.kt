package com.amrhishammahmoud.rahhal.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@kotlinx.parcelize.Parcelize
@Entity(tableName = "countries_api_data")
data class CountriesSummaryData(
    @PrimaryKey
    @SerializedName("countryName")
    var countryName: String,
    @SerializedName("countryFlag")
    var countryFlag: String,
    @SerializedName("countryPopulation")
    var countryPopulation: Int,
    @SerializedName("countryArea")
    var countryArea: Double,
    @SerializedName("countryContinent")
    var countryContinent: String,
    @SerializedName("countryCapital")
    var countryCapital: String,
    @SerializedName("countryMap")
    var countryMap : String
) : Parcelable
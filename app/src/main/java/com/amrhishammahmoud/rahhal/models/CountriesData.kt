package com.amrhishammahmoud.rahhal.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountriesData(
    var countriesDataDetails : List<CountriesDataDetails>
)

data class CountriesDataDetails(
    var flags: Flags,
    var name: Name,
    var capital: List<String>,
    var area: Double,
    var maps : Maps,
    var population: Int,
    var continents: List<String>
)

data class Flags(
    var png: String,
    var svg: String,
    var alt: String
)

data class Name (
    var common: String,
    var official: String,
    var nativeName: Map<String, NativeName>
)

data class NativeName (
    var official: String,
    var common: String
)


data class Maps(
    var googleMaps: String,
    var openStreetMaps: String
)


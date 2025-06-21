package com.amrhishammahmoud.rahhal.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.amrhishammahmoud.rahhal.models.APIForCountries
import com.amrhishammahmoud.rahhal.models.ContinentsApiObject
import com.amrhishammahmoud.rahhal.models.ContinentsData
import com.amrhishammahmoud.rahhal.models.CountriesData
import com.amrhishammahmoud.rahhal.models.CountriesDataDetails
import com.amrhishammahmoud.rahhal.models.CountriesPicturesApiObject
import com.amrhishammahmoud.rahhal.models.CountriesSummaryData
import com.amrhishammahmoud.rahhal.models.FamousApiObject
import com.amrhishammahmoud.rahhal.models.FamousData
import com.amrhishammahmoud.rahhal.models.PicturesData
import com.amrhishammahmoud.rahhal.models.Users
import com.amrhishammahmoud.rahhal.roomDatabase.DaoUsers
import com.amrhishammahmoud.rahhal.roomDatabase.DoeContinents
import com.amrhishammahmoud.rahhal.roomDatabase.DoeCountries
import com.amrhishammahmoud.rahhal.roomDatabase.DoeFamous
import com.amrhishammahmoud.rahhal.roomDatabase.DoePicturesCountries
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val dataDaoUsers: DaoUsers,
    private val dataDaoContinents: DoeContinents,
    private val dataDaoCountries: DoeCountries,
    private val dataDaoPicturesCountries : DoePicturesCountries,
    private val dataDaoFamous: DoeFamous
) {

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataUsers(data: Users) {
        dataDaoUsers.addDataForRegistration(data)
    }

    suspend fun login(userEmail: String, userPassword: String): Users {
        return dataDaoUsers.login(userEmail, userPassword)
    }

    suspend fun loginSplash(): Users {
        return dataDaoUsers.loginSplash()
    }

    /********************************************************************************************/

    val readAllDataContinents: LiveData<List<ContinentsData>> =
        dataDaoContinents.readAllDataContinents()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataContinents(data: List<ContinentsData>) {
        dataDaoContinents.addDataContinents(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataContinents(data: List<ContinentsData>) {
        dataDaoContinents.updateADataContinents(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataContinents(data: List<ContinentsData>) {
        dataDaoContinents.deleteDataContinents(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataContinents() {
        dataDaoContinents.deleteAllDataContinents()
    }


    //to parse and insert data to database by dao (with room data base)
    suspend fun getContinentsDataAndPutItIntoRoomDBByDao(context: Context) {
        val resultContinentsName = ContinentsApiObject.continentsNames(context)
        val resultContinentsMapBackground = ContinentsApiObject.continentsMapsBackground()

        val array = ArrayList<ContinentsData>()
        var i = 0
        for (i in 0..6) {
            array.add(
                ContinentsData(
                    i + 1,
                    resultContinentsName[i],
                    resultContinentsMapBackground[i]
                )
            )
        }

        dataDaoContinents.addDataContinents(array)
    }

    /*********************************************************************************************/

    val readAllDataCountriesSummary: LiveData<List<CountriesSummaryData>> =
        dataDaoCountries.readAllDataCountries()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataCountriesSummary(data: List<CountriesSummaryData>) {
        dataDaoCountries.addDataCountries(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataCountriesSummary(data: List<CountriesSummaryData>) {
        dataDaoCountries.updateADataCountries(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataCountriesSummary(data: List<CountriesSummaryData>) {
        dataDaoCountries.deleteDataCountries(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataCountriesSummary() {
        dataDaoCountries.deleteAllDataCountries()
    }

    //for get the data directly from the service without put it into room database
    suspend fun getDataFromApiRepositoryCountriesSummary(
        fields: String
    ): Flow<List<CountriesDataDetails>> {
        return flow {
            val response =
                APIForCountries.apiServiceCountries.getDataFromApiRetrofitServiceForCountriesSummary(
                    fields
                )
            if (response.isSuccessful) {
                val data = response.body() ?: emptyList()
                emit(data)
            } else {
                // Handle error appropriately, e.g., log it or throw
                emit(emptyList()) // Or throw exception if needed
            }

        }
    }


    /********************************************************************************************/


    val readAllDataContinentsPictures: LiveData<List<PicturesData>> =
        dataDaoPicturesCountries.readAllDataCountriesPictures()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataContinentsPictures(data: List<PicturesData>) {
        dataDaoPicturesCountries.addDataCountriesPictures(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataContinentsPictures(data: List<PicturesData>) {
        dataDaoPicturesCountries.updateADataCountriesPictures(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataContinentsPictures(data: List<PicturesData>) {
        dataDaoPicturesCountries.deleteDataCountriesPictures(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataContinentsPictures() {
        dataDaoPicturesCountries.deleteAllDataCountriesPictures()
    }


    //to parse and insert data to database by dao (with room data base)
    suspend fun getContinentsPicturesDataAndPutItIntoRoomDBByDao() {
        val resultCountriesPictures = CountriesPicturesApiObject.countriesPictures()

        val array = ArrayList<PicturesData>()
        var i = 0
        for (i in 0 until 247) {
            array.add(
                PicturesData(
                    i + 1,
                    resultCountriesPictures[i].toString()
                )
            )
        }

        dataDaoPicturesCountries.addDataCountriesPictures(array)
    }

    /*********************************************************************************************/


    val readAllDataFamous: LiveData<List<FamousData>> =
        dataDaoFamous.readAllDataFamous()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataFamous(data: List<FamousData>) {
        dataDaoFamous.addDataFamous(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataFamous(data: List<FamousData>) {
        dataDaoFamous.updateADataFamous(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteData(data: List<FamousData>) {
        dataDaoFamous.deleteDataFamous(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataFamous() {
        dataDaoFamous.deleteAllDataFamous()
    }


    //to parse and insert data to database by dao (with room data base)
    suspend fun getFamousDataAndPutItIntoRoomDBByDao() {
        val resultFamousName = FamousApiObject.famousNames()
        val resultFamousCountry = FamousApiObject.famousCountriesNames()
        val resultFamousCapital = FamousApiObject.famousCapitalsNames()
        val resultFamousImage = FamousApiObject.famousImages()

        val array = ArrayList<FamousData>()
        for (i in 0..24) {
            array.add(
                FamousData(
                    resultFamousImage[i],
                    resultFamousCountry[i],
                    resultFamousCapital[i],
                    resultFamousName[i]
                )
            )
        }

        dataDaoFamous.addDataFamous(array)
    }

    /*********************************************************************************************/


}
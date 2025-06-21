package com.amrhishammahmoud.rahhal.roomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.amrhishammahmoud.rahhal.models.ContinentsData
import com.amrhishammahmoud.rahhal.models.CountriesSummaryData
import com.amrhishammahmoud.rahhal.models.FamousData
import com.amrhishammahmoud.rahhal.models.PicturesData
import com.amrhishammahmoud.rahhal.models.Users

@androidx.room.Dao
interface DaoUsers {

    @Insert
    suspend fun addDataForRegistration(data: Users)

    @Query("SELECT * from users_table where email=:userEmail and password=:userPassword")
    suspend fun login(userEmail: String,userPassword: String): Users

    @Query("SELECT * from users_table")
    suspend fun loginSplash(): Users
}

/****************************************************************************/

@androidx.room.Dao
interface DoeContinents {

    //To read all data in data base :
    @Query("SELECT * FROM continents_table ORDER BY id ASC")
    fun readAllDataContinents() : LiveData<List<ContinentsData>>

    //To insert data in data base :
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDataContinents(data:List<ContinentsData>)

    //To update data in data base (i don't need it now but for learning):
    @Update
    suspend fun updateADataContinents(data: List<ContinentsData>)

    //To delete data in data base (i don't need it now but for learning):
    @Delete
    suspend fun deleteDataContinents(data: List<ContinentsData>)

    //To delete all data in data base ( i don't need it now but for learning):
    @Query("DELETE FROM continents_table")
    suspend fun deleteAllDataContinents()

}

/****************************************************************************/

@androidx.room.Dao
interface DoeCountries {

    //To read all data in data base :
    @Query("SELECT * FROM countries_api_data ORDER BY countryName ASC")
    fun readAllDataCountries() : LiveData<List<CountriesSummaryData>>

    //To insert data in data base :
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDataCountries(data:List<CountriesSummaryData>)

    //To update data in data base (i don't need it now but for learning):
    @Update
    suspend fun updateADataCountries(data: List<CountriesSummaryData>)

    //To delete data in data base (i don't need it now but for learning):
    @Delete
    suspend fun deleteDataCountries(data: List<CountriesSummaryData>)

    //To delete all data in data base ( i don't need it now but for learning):
    @Query("DELETE FROM countries_api_data")
    suspend fun deleteAllDataCountries()

}

/****************************************************************************/

@androidx.room.Dao
interface DoePicturesCountries {

    //To read all data in data base :
    @Query("SELECT * FROM pictures_table ORDER BY id ASC")
    fun readAllDataCountriesPictures() : LiveData<List<PicturesData>>

    //To insert data in data base :
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDataCountriesPictures(data:List<PicturesData>)

    //To update data in data base (i don't need it now but for learning):
    @Update
    suspend fun updateADataCountriesPictures(data: List<PicturesData>)

    //To delete data in data base (i don't need it now but for learning):
    @Delete
    suspend fun deleteDataCountriesPictures(data: List<PicturesData>)

    //To delete all data in data base ( i don't need it now but for learning):
    @Query("DELETE FROM pictures_table")
    suspend fun deleteAllDataCountriesPictures()

}

/****************************************************************************/


@androidx.room.Dao
interface DoeFamous {

    //To read all data in data base :
    @Query("SELECT * FROM famous_table ORDER BY famousImage ASC")
    fun readAllDataFamous() : LiveData<List<FamousData>>

    //To insert data in data base :
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDataFamous(data:List<FamousData>)

    //To update data in data base (i don't need it now but for learning):
    @Update
    suspend fun updateADataFamous(data: List<FamousData>)

    //To delete data in data base (i don't need it now but for learning):
    @Delete
    suspend fun deleteDataFamous(data: List<FamousData>)

    //To delete all data in data base ( i don't need it now but for learning):
    @Query("DELETE FROM famous_table")
    suspend fun deleteAllDataFamous()

}

/****************************************************************************/

package com.amrhishammahmoud.rahhal.di

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.amrhishammahmoud.rahhal.models.ContinentsData
import com.amrhishammahmoud.rahhal.models.CountriesData
import com.amrhishammahmoud.rahhal.models.CountriesDataDetails
import com.amrhishammahmoud.rahhal.models.CountriesSummaryData
import com.amrhishammahmoud.rahhal.models.FamousData
import com.amrhishammahmoud.rahhal.models.PicturesData
import com.amrhishammahmoud.rahhal.roomDatabase.DaoUsers
import com.amrhishammahmoud.rahhal.roomDatabase.DoeContinents
import com.amrhishammahmoud.rahhal.roomDatabase.DoeCountries
import com.amrhishammahmoud.rahhal.roomDatabase.DoeFamous
import com.amrhishammahmoud.rahhal.roomDatabase.DoePicturesCountries
import com.amrhishammahmoud.rahhal.roomDatabase.RoomDatabaseContinents
import com.amrhishammahmoud.rahhal.roomDatabase.RoomDatabaseCountries
import com.amrhishammahmoud.rahhal.roomDatabase.RoomDatabaseFamous
import com.amrhishammahmoud.rahhal.roomDatabase.RoomDatabasePicturesCountries
import com.amrhishammahmoud.rahhal.roomDatabase.RoomDatabaseUsers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetDaoUsers(appDB: RoomDatabaseUsers): DaoUsers {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseUsers(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseUsers::class.java, "Users_DataBase"
    ).build()
    /****************************************************************************/

    @Provides
    @Singleton
    fun provideLiveDataVariableContinents(appDB: RoomDatabaseContinents): LiveData<List<ContinentsData>> =
        appDB.dataDao().readAllDataContinents()

    @Provides
    @Singleton
    fun provideGetDaoContinents(appDB: RoomDatabaseContinents): DoeContinents {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseContinents(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseContinents::class.java, "continents_table"
    ).build()


    /****************************************************************************/


    @Provides
    @Singleton
    fun provideLiveDataVariableCountriesSummary(appDB: RoomDatabaseCountries) : LiveData<List<CountriesSummaryData>> = appDB.dataDao().readAllDataCountries()

    @Provides
    @Singleton
    fun provideMutableLiveDataCountriesSummary() = MutableLiveData<List<CountriesDataDetails>>()


    @Provides
    @Singleton
    fun provideGetDaoCountriesSummary(appDB: RoomDatabaseCountries): DoeCountries {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseCountriesSummary(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,RoomDatabaseCountries::class.java,"countries_api_data"
    ).build()


    /****************************************************************************/

    @Provides
    @Singleton
    fun provideLiveDataVariableContinentsPictures(appDB: RoomDatabasePicturesCountries): LiveData<List<PicturesData>> =
        appDB.dataDao().readAllDataCountriesPictures()

    @Provides
    @Singleton
    fun provideGetDaoContinentsPictures(appDB: RoomDatabasePicturesCountries): DoePicturesCountries {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseContinentsPictures(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabasePicturesCountries::class.java, "pictures_table"
    ).build()


    /****************************************************************************/


    @Provides
    @Singleton
    fun provideLiveDataVariableFamous(appDB: RoomDatabaseFamous): LiveData<List<FamousData>> =
        appDB.dataDao().readAllDataFamous()

    @Provides
    @Singleton
    fun provideGetDaoFamous(appDB: RoomDatabaseFamous): DoeFamous {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseFamous(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseFamous::class.java, "famous_table"
    ).build()


    /****************************************************************************/



}


package com.amrhishammahmoud.rahhal.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.rahhal.models.CountriesSummaryData


@Database(entities = [CountriesSummaryData::class], version = 1, exportSchema = false)
abstract class RoomDatabaseCountries: RoomDatabase() {
    abstract fun dataDao(): DoeCountries

    companion object{
        @Volatile
        private var Instance : RoomDatabaseCountries?=null
        fun getInstance(context: Context): RoomDatabaseCountries {
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabaseCountries::class.java,
                    "countries_DataBase"
                ).build()
                Instance = instance
                return instance
            }
        }
    }
}
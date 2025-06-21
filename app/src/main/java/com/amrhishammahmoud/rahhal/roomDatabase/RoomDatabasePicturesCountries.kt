package com.amrhishammahmoud.rahhal.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.rahhal.models.ContinentsData
import com.amrhishammahmoud.rahhal.models.PicturesData


@Database(entities = [PicturesData::class], version = 1, exportSchema = false)
abstract class RoomDatabasePicturesCountries: RoomDatabase() {
    abstract fun dataDao(): DoePicturesCountries

    companion object{
        @Volatile
        private var Instance : RoomDatabasePicturesCountries?=null
        fun getInstance(context: Context): RoomDatabasePicturesCountries {
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabasePicturesCountries::class.java,
                    "pictures_countries_DataBase"
                ).build()
                Instance = instance
                return instance
            }
        }
    }
}


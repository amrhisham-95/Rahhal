package com.amrhishammahmoud.rahhal.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.rahhal.models.ContinentsData
import kotlin.jvm.java


@Database(entities = [ContinentsData::class], version = 1, exportSchema = false)
abstract class RoomDatabaseContinents: RoomDatabase() {
    abstract fun dataDao(): DoeContinents

    companion object{
        @Volatile
        private var Instance : RoomDatabaseContinents?=null
        fun getInstance(context: Context): RoomDatabaseContinents {
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabaseContinents::class.java,
                    "continents_DataBase"
                ).build()
                Instance = instance
                return instance
            }
        }
    }
}

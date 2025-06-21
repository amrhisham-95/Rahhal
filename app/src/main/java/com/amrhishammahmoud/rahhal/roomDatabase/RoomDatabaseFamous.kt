package com.amrhishammahmoud.rahhal.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.rahhal.models.FamousData


@Database(entities = [FamousData::class], version = 1, exportSchema = false)
abstract class RoomDatabaseFamous: RoomDatabase() {
    abstract fun dataDao(): DoeFamous

    companion object{
        @Volatile
        private var Instance : RoomDatabaseFamous?=null
        fun getInstance(context: Context): RoomDatabaseFamous {
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabaseFamous::class.java,
                    "famous_DataBase"
                ).build()
                Instance = instance
                return instance
            }
        }
    }
}

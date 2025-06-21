package com.amrhishammahmoud.rahhal.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.rahhal.models.Users


@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class RoomDatabaseUsers: RoomDatabase() {
    abstract fun dataDao(): DaoUsers

    companion object{
        @Volatile
        private var Instance : RoomDatabaseUsers?=null
        fun getInstance(context: Context): RoomDatabaseUsers {
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    RoomDatabaseUsers::class.java,
                    "Users_DataBase").build()
                Instance = instance
                return instance
            }
        }
    }
}
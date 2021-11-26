package com.example.jetpackcomposeexample.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackcomposeexample.model.local.Login

@Database(entities = arrayOf(Login::class), version = 1)
abstract class DemoDatabase : RoomDatabase() {
    abstract val demoDao: DemoDao

    companion object {
        @Volatile
        private var INSTANT: DemoDatabase? = null

        @Synchronized
        fun getInstance(context: Context): DemoDatabase {
            return INSTANT ?: Room.databaseBuilder(
                context.applicationContext,
                DemoDatabase::class.java,
                "demo_database"
            ).build().also {
                INSTANT = it
            }
        }
    }
}
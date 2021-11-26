package com.example.jetpackcomposeexample.repository.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jetpackcomposeexample.model.local.Login

@Dao
interface DemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(login: Login)

    @Transaction
    @Query("SELECT * FROM table_login")
    fun getLogin(): LiveData<Login>
}
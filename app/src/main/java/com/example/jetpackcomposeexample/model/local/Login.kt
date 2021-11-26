package com.example.jetpackcomposeexample.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_login")
data class Login(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("mobile")
    var mobile: String? = "",
    @SerializedName("gender")
    var gender: String? = ""

)

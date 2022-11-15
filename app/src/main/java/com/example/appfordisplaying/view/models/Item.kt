package com.example.appfordisplaying.view.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "items_comments")
@JsonClass(generateAdapter = true)
data class Item(
    @ColumnInfo(name = "name")
    @Json(name = "name")
    val name: String = "",
    @ColumnInfo(name = "body")
    @Json(name = "body")
    val body: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    var id: Int = 0
}
package com.example.appfordisplaying.view.database

import androidx.room.*
import com.example.appfordisplaying.view.models.Item

@Dao
interface ItemDatabaseDao {
    @Insert(entity = Item::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Query("SELECT * FROM items_comments")
    suspend fun getAllItems(): List<Item>

    @Query("SELECT * from items_comments LIMIT 1")
    suspend fun listEmpty(): Item?

    @Delete
    suspend fun delete(item: Item)
}
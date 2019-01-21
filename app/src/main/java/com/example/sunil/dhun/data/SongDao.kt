package com.example.sunil.dhun.data

import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface SongDao {
    @Insert
    fun insert(song:Song)

    @Update
    fun update(song:Song)

    @Query("DELETE FROM song_table")
    fun deleteAll()

    @Query("SELECT * FROM song_table")
    fun getAllSongs(): MutableLiveData<List<Song>>
}
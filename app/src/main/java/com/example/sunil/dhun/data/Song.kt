package com.example.sunil.dhun.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "song_table")
class Song(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    private val song:String,
    private val artist:String,
    @ColumnInfo(name = "icon_url")
    private val iconUrl:String,
    @ColumnInfo(name = "total_time")
    private val totalTime:Long,
    @ColumnInfo(name = "resumed_time")
    private val resumedTime:Long,
    @ColumnInfo(name = "add_to_favourites")
    private val addToFavourites:Boolean,
    private val repeat:Boolean) {
    override fun toString(): String {
        return "$id - $song - $artist - $iconUrl - $totalTime - $resumedTime - $addToFavourites - $repeat"
    }
}
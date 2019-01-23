package com.example.sunil.dhun.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "song_table")
class Song(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val song:String,
    val artist:String,
    @ColumnInfo(name = "icon_url")
    val iconUrl:String,
    @ColumnInfo(name = "total_time")
    val totalTime:Long,
    @ColumnInfo(name = "resumed_time")
    val resumedTime:Long,
    @ColumnInfo(name = "add_to_favourites")
    val addToFavourites:Boolean,
    val repeat:Boolean) {
    override fun toString(): String {
        return "$id - $song - $artist - $iconUrl - $totalTime - $resumedTime - $addToFavourites - $repeat"
    }
}
package com.example.sunil.dhun.data

data class Play(val id:Int,
                val song:String,
                val artist:String,
                val iconUrl:String,
                val totalTime:Long,
                val resumedTime:Long,
                val addToFavourites:Boolean,
                val repeat:Boolean) {

    override fun toString(): String {
        return "$id - $song - $artist - $iconUrl - $totalTime - $resumedTime - $addToFavourites - $repeat"
    }
}
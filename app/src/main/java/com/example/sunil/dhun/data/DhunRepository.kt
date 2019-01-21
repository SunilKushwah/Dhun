package com.example.sunil.dhun.data

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask


class DhunRepository {
    var mSongDao:SongDao
    var allSong:MutableLiveData<List<Song>>

    constructor(application: Application){
        val db = DhunRoomDatabase.getDatabase(application)
        mSongDao = db!!.songDao()
        allSong = mSongDao.getAllSongs()
    }

    fun getAllSongs():MutableLiveData<List<Song>>{
        return allSong
    }

    fun insert(song:Song){
        InsertAsyncTask(mSongDao).execute(song)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: SongDao) :
        AsyncTask<Song, Void, Void>() {

        override fun doInBackground(vararg params: Song): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}


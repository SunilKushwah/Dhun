package com.example.sunil.dhun.ui.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sunil.dhun.MyApplication
import com.example.sunil.dhun.data.DhunRepository
import com.example.sunil.dhun.data.DhunRoomDatabase
import com.example.sunil.dhun.data.Song

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DhunRepository
    val mAllSongs: LiveData<List<Song>>

    init {
        val songsDao = DhunRoomDatabase.getDatabase(application)!!.songDao()
        repository = DhunRepository(application)
        mAllSongs = repository.allSong
    }


    fun getAllSongs(): LiveData<List<Song>> {
        return mAllSongs
    }

    fun insert(song: Song){
        repository!!.insert(song)
    }
}

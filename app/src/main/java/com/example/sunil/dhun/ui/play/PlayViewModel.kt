package com.example.sunil.dhun.ui.play

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sunil.dhun.data.DhunRepository
import com.example.sunil.dhun.data.Song

class PlayViewModel(application: Application) : ViewModel() {
    // TODO: Implement the ViewModel
    var mRepository:DhunRepository = DhunRepository(application)
    private var mAllSongs:MutableLiveData<List<Song>>

    init {
        mAllSongs = mRepository.getAllSongs()
    }

    fun getAllSongs():MutableLiveData<List<Song>>{
        return mAllSongs
    }

    fun insert(song:Song){
        mRepository.insert(song)
    }


}

package com.example.sunil.dhun.ui.home

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sunil.dhun.data.DhunRepository
import com.example.sunil.dhun.data.Song

class HomeViewModel(application: Application) : ViewModel() {

    lateinit var mRepository: DhunRepository
    private lateinit var mAllSongs: MutableLiveData<List<Song>>
    init {
        mRepository = DhunRepository(Application())
        mAllSongs = mRepository.getAllSongs()
    }

    fun getAllSongs(): MutableLiveData<List<Song>> {
        return mAllSongs
    }

    fun insert(song: Song){
        mRepository.insert(song)
    }
}

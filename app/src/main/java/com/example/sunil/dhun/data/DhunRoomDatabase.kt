package com.example.sunil.dhun.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.arch.persistence.room.Room
import android.os.AsyncTask.execute
import android.arch.persistence.db.SupportSQLiteDatabase
import android.support.annotation.NonNull
import android.os.AsyncTask







@Database(entities = [Song::class], version = 1)
abstract class DhunRoomDatabase: RoomDatabase() {
    abstract fun songDao():SongDao

    companion object {
        private var INSTANCE:DhunRoomDatabase? = null

        fun getDatabase(context: Context): DhunRoomDatabase? {
            if(INSTANCE==null){
                synchronized(DhunRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DhunRoomDatabase::class.java, "dhun_database"
                        ).addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE!!).execute()
            }
        }

        private class PopulateDbAsync internal constructor(db: DhunRoomDatabase) : AsyncTask<Void, Void, Void>() {

            private val mDao: SongDao = db.songDao()

            override fun doInBackground(vararg params: Void): Void? {
                mDao.deleteAll()
                var song = Song(1,"song1","arijit","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(2,"song2","sonu","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(3,"song3","kher","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(4,"song4","jubin","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(5,"song5","jeet","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(6,"song6","lucky","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(7,"song7","atif","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(8,"song8","neeti","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(9,"song9","papon","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                song = Song(10,"song10","amit","https://picsum.photos/200/200/?blur",10,5,false,false)
                mDao.insert(song)
                return null
            }
        }
    }




}
package com.example.sunil.dhun.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.arch.persistence.room.Room



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
                            DhunRoomDatabase::class.java!!, "dhun_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }




}
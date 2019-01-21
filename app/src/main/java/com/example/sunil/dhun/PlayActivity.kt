package com.example.sunil.dhun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sunil.dhun.ui.play.PlayFragment

class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PlayFragment.newInstance())
                .commitNow()
        }
    }

}

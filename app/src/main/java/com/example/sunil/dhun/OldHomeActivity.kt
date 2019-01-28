package com.example.sunil.dhun

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast


class OldHomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    HomeActivityRecyclerViewAdapter.OnClickLenderListener{

    lateinit var allSampleData:ArrayList<SectionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        // createDummyData()
        val homeContentRecyclerView = findViewById<RecyclerView>(R.id.home_content_rv)
        homeContentRecyclerView.setHasFixedSize(true)
        val adapter = HomeActivityRecyclerViewAdapter(this, allSampleData)
        homeContentRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.setOnClickListener(this)
        homeContentRecyclerView.adapter = adapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onClickSectionMore(section: Int) {
        Toast.makeText(this, "more section Position $section",Toast.LENGTH_LONG).show()
    }

    override fun onClickSectionItem(section: Int, position: Int) {
        Toast.makeText(this, "more section Position $section $position",Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    /*fun createDummyData() {
        allSampleData = ArrayList<SectionModel>()
        for (i in 1..5) {
            val singleItem = ArrayList<SectionItemModel>()
            for (j in 0..5) {
                singleItem.add(SectionItemModel(j,"Item $j", "https://picsum.photos/200/200/?blur"))
            }
            allSampleData.add(SectionModel("Section $i",singleItem))

        }
    }*/
}

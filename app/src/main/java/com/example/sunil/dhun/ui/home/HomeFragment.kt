package com.example.sunil.dhun.ui.home

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sunil.dhun.HomeActivityRecyclerViewAdapter
import com.example.sunil.dhun.R
import com.example.sunil.dhun.SectionItemModel
import com.example.sunil.dhun.SectionModel
import com.example.sunil.dhun.data.Song



class HomeFragment : Fragment(), HomeActivityRecyclerViewAdapter.OnClickLenderListener{
    var allSampleData:ArrayList<SectionModel> = ArrayList()

    companion object {
        fun newInstance() = HomeFragment()
    }
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: HomeActivityRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = inflater.inflate(R.layout.home_fragment, container, false)
        //createDummyData()
        val homeContentRecyclerView = layout.findViewById(R.id.home_content_rv) as RecyclerView
        homeContentRecyclerView.setHasFixedSize(true)
        adapter = HomeActivityRecyclerViewAdapter(context!!, allSampleData)
        homeContentRecyclerView.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        adapter.setOnClickListener(this)
        homeContentRecyclerView.adapter = adapter
        return layout

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel(Application())::class.java)
        viewModel.getAllSongs().observe(this, object:Observer<List<Song>>{
            override fun onChanged(t: List<Song>?) {
                allSampleData = ArrayList()
                for (i in 1..5) {
                    val singleItem = ArrayList<SectionItemModel>()
                    for (j in t!!.indices) {
                        val song = t[j]
                        singleItem.add(SectionItemModel(song.id,song.song,song.iconUrl))
                    }
                    allSampleData.add(SectionModel("Section $i",singleItem))

                }
                adapter.setData(allSampleData)
            }
        })
    }

    override fun onClickSectionMore(section: Int) {
        Toast.makeText(context, "more section Position $section", Toast.LENGTH_LONG).show()
    }

    override fun onClickSectionItem(section: Int, position: Int) {
        Toast.makeText(context, "more section Position $section $position",Toast.LENGTH_LONG).show()
    }

    private fun createDummyData() {
        allSampleData = ArrayList()
        for (i in 1..5) {
            val singleItem = ArrayList<SectionItemModel>()
            for (j in 0..5) {
                singleItem.add(SectionItemModel(i,"Item $j", "https://picsum.photos/200/200/?blur"))
            }
            allSampleData.add(SectionModel("Section $i",singleItem))

        }
    }

}

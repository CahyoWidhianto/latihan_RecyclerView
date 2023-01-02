package com.example.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTeamSepakBola: RecyclerView
    private val list = ArrayList<TeamSepakBola>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTeamSepakBola =findViewById(R.id.rv_team_sepakbola)
        rvTeamSepakBola.setHasFixedSize(true)


        list.addAll(listTeamSepakBola)
        tampilkanRecycelerView()
    }

    private val listTeamSepakBola : ArrayList<TeamSepakBola>
    get() {
        val dataNama = resources.getStringArray(R.array.data_nama_team)
        val dataDeskripsi = resources.getStringArray(R.array.data_deskripsi_team)
        val dataLogo = resources.obtainTypedArray(R.array.data_logo_team)
        val listTeam = ArrayList<TeamSepakBola>()
        for(i in dataNama.indices){
            val team = TeamSepakBola(
                dataNama[i],
                dataDeskripsi[i],
                dataLogo.getResourceId(i,-1)
            )
            listTeam.add(team)
        }
        return listTeam
    }

    private fun tampilkanRecycelerView(){
        rvTeamSepakBola.layoutManager =LinearLayoutManager(this)
        val teamSepakBolaAdapter = TeamSepakBolaAdapter(list)
        rvTeamSepakBola.adapter = teamSepakBolaAdapter
    }
}
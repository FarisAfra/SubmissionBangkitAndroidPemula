package com.example.submissionandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvSkills: RecyclerView
    private val list = ArrayList<Skill>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProfile: ImageButton = findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener(this)

        rvSkills = findViewById(R.id.rv_skills)
        rvSkills.setHasFixedSize(true)

        list.addAll(getListSkill())
        showRecyclerList()
    }

    private fun getListSkill(): ArrayList<Skill> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSkill = ArrayList<Skill>()
        for (i in dataName.indices) {
            val hero = Skill(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listSkill.add(hero)
        }
        return listSkill
    }

    private fun showRecyclerList() {
        rvSkills.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListSkillAdapter(list)
        rvSkills.adapter = listHeroAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_profile -> {
                val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveAbout)
            }
        }
    }
}
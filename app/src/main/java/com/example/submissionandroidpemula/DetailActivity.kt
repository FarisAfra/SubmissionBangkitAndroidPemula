package com.example.submissionandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_SKILL = "extra_skill"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btn_backhome: ImageButton = findViewById(R.id.btn_back)
        btn_backhome.setOnClickListener(this)

        val skill = intent.getParcelableExtra<Skill>(EXTRA_SKILL)
        if (skill != null) {
            val tvName: TextView = findViewById(R.id.tv_skill_name)
            tvName.text = skill.name

            val tvDescription: TextView = findViewById(R.id.tv_skill_description)
            tvDescription.text = skill.description

            val imgPhoto: ImageView = findViewById(R.id.img_skill_photo)
            imgPhoto.setImageResource(skill.photo)

            val tvHistory: TextView = findViewById(R.id.tv_skill_history)
            tvHistory.text = skill.history

            val tvYear: TextView = findViewById(R.id.tv_skill_year)
            tvYear.text = skill.year.toString()

            val tvVersion: TextView = findViewById(R.id.tv_skill_version)
            tvVersion.text = skill.version
        }

        val btnShare: ImageButton = findViewById(R.id.action_share)
        btnShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Cek Website ${skill?.name} di ${skill?.website}")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back -> {
                val moveBackHome = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveBackHome)
            }
        }
    }
}
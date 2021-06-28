package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_SKILL
import com.example.swoosh.databinding.ActivitySkillBinding

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    private lateinit var binding: ActivitySkillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        league = intent.getStringExtra(EXTRA_LEAGUE).toString()
    }

    fun onBallerClick (view: View) {
        binding.beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClick (view: View) {
        binding.ballerSkillBtn.isChecked = false
        skill = "beginner"
    }


    fun onSkillFinishClicked(view: View){
        if (skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }

    }
}
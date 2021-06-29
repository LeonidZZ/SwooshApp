package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import com.example.swoosh.databinding.ActivitySkillBinding

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    private lateinit var binding: ActivitySkillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        player = intent.getParcelableExtra(EXTRA_PLAYER)!!
    }

    fun onBallerClick (view: View) {
        binding.beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onBeginnerClick (view: View) {
        binding.ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }


    fun onSkillFinishClicked(view: View){
        if (player.skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }

    }
}
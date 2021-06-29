package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.Utilities.EXTRA_PLAYER
import com.example.swoosh.databinding.ActivityLeagueBinding

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    private lateinit var binding: ActivityLeagueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }



    fun onMensClicked(view: View) {
        binding.womensLeagueBtn.isChecked = false
        binding.coedLeagueBtn.isChecked = false

        player.league = "mens"
    }


    fun onWomensClicked(view: View) {
        binding.mensLeagueBtn.isChecked = false
        binding.coedLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        binding.mensLeagueBtn.isChecked = false
        binding.womensLeagueBtn.isChecked = false

        player.league = "co-ed"

    }


    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
}
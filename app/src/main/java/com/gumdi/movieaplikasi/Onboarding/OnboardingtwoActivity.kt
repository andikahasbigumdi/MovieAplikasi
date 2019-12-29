package com.gumdi.movieaplikasi.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gumdi.movieaplikasi.R
import kotlinx.android.synthetic.main.acttivity_onboarding_two.*

class OnboardingtwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acttivity_onboarding_two)

        buttonlanjutkanpresale.setOnClickListener {
            var intent = Intent(this,OnboardingtreeActivity::class.java)
            startActivity(intent)
        }
    }
}

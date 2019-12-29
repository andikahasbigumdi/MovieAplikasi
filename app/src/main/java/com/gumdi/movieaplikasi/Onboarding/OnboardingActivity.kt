package com.gumdi.movieaplikasi.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gumdi.movieaplikasi.R
import com.gumdi.movieaplikasi.Sign.Signin.SigninActivity
import com.gumdi.movieaplikasi.Utils.Preferences
import kotlinx.android.synthetic.main.acttivity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    //lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acttivity_onboarding)

        //preferences = Preferences(this)
        //if (preferences.getValues("onboarding").equals("1")) {
        //finishAffinity()
        //val intent = Intent(this,SigninActivity::class.java)
        //startActivity(intent)
        //}

        buttonlanjutkan.setOnClickListener {
            var intent = Intent(this,OnboardingtwoActivity::class.java)
            startActivity(intent)
        }

        buttonlewatitampilan.setOnClickListener {

//            preferences.setValues("onboarding", "1")
            finishAffinity()
            var intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onBackPressed() {
    }
}


package com.gumdi.movieaplikasi.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gumdi.movieaplikasi.R
import com.gumdi.movieaplikasi.Sign.Signin.SigninActivity
import kotlinx.android.synthetic.main.acttivity_onboarding_tree.*

class OnboardingtreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acttivity_onboarding_tree)


        buttonlanjutkancashless.setOnClickListener {
            var intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}

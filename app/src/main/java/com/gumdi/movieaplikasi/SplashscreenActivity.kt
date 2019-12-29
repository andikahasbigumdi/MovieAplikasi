package com.gumdi.movieaplikasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gumdi.movieaplikasi.Onboarding.OnboardingActivity


//Menggubah waktu Dellay Pada SplashScreen

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        var handler=Handler()
        handler.postDelayed({
            var intent = Intent(this,OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}

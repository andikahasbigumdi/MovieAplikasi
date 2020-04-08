package com.gumdi.movieaplikasi.Checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gumdi.movieaplikasi.Home.HomeActivity
import com.gumdi.movieaplikasi.Home.TiketActivity
import com.gumdi.movieaplikasi.R
import kotlinx.android.synthetic.main.activity_checkout_success.*

class CheckoutSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_success)

        btn_home.setOnClickListener {
            val intent = Intent(this@CheckoutSuccessActivity,
                HomeActivity::class.java)
            startActivity(intent)
        }

        btn_tiket.setOnClickListener {
            var intent = Intent(this@CheckoutSuccessActivity,TiketActivity::class.java)
            startActivity(intent)
        }

    }
}

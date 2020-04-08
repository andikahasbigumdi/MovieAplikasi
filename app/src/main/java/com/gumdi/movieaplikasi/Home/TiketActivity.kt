package com.gumdi.movieaplikasi.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gumdi.movieaplikasi.Checkout.Model.Checkout
import com.gumdi.movieaplikasi.Home.Model.Film
import com.gumdi.movieaplikasi.MyHistoryActivity
import com.gumdi.movieaplikasi.R
import kotlinx.android.synthetic.main.activity_tiket.*

class TiketActivity : AppCompatActivity() {

    private var dataList = ArrayList<Checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiket)

        val data = intent.getParcelableExtra<Film>("data")

        tv_title.text = data.judul
        tv_genre.text = data.genre
        tv_rate.text = data.rating

        Glide.with(this)
            .load(data.poster)
            .into(iv_poster_image)

        rc_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(Checkout("C1",""))
        dataList.add(Checkout("C2",""))

        rc_checkout.adapter = TiketAdapter(dataList) {
        }

        imageView3.setOnClickListener {
            var intent = Intent(this,MyHistoryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
    }

}

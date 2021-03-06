package com.gumdi.movieaplikasi.Checkout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gumdi.movieaplikasi.Checkout.Model.Checkout
import com.gumdi.movieaplikasi.DetailActivity
import com.gumdi.movieaplikasi.Home.Model.Film
import com.gumdi.movieaplikasi.R
import kotlinx.android.synthetic.main.activity_pilih_bangku.*

class PilihBangkuActivity :AppCompatActivity(){

    var statusA3:Boolean = false
    var statusA4:Boolean = false
    var total:Int = 0
    private var dataList = ArrayList<Checkout>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_bangku)

        val data = intent.getParcelableExtra<Film>("data")

        tv_kursi.text = data.judul

        a3.setOnClickListener {
            if (statusA3) {
                a3.setImageResource(R.drawable.ic_rectangle_empty)
                statusA3 = false
                total -=1
                belitiket(total)

            } else {
                a3.setImageResource(R.drawable.ic_rectangle_selected)
                statusA3 = true
                total +=1
                belitiket(total)

                val data = Checkout("A3", "70000")
                dataList.add(data)
            }
        }

        a4.setOnClickListener {
            if (statusA4) {
                a4.setImageResource(R.drawable.ic_rectangle_empty)
                statusA4 = false
                total -=1
                belitiket(total)
            } else {
                a4.setImageResource(R.drawable.ic_rectangle_selected)
                statusA4 = true
                total +=1
                belitiket(total)

                val data = Checkout("A4", "70000")
                dataList.add(data)
            }
        }

        btn_home.setOnClickListener {

            val intent = Intent(this, CheckoutActivity::class.java).putExtra("data", dataList).putExtra("datas", data)
            startActivity(intent)
        }

        imageView3.setOnClickListener {

            val intent = Intent(this@PilihBangkuActivity,DetailActivity::class.java)
            startActivity(intent)
        }

    }

    private fun belitiket(total:Int) {
        if (total == 0) {
            btn_home.setText("Beli Tiket")
            btn_home.visibility = View.INVISIBLE
        } else {
            btn_home.setText("Beli Tiket ("+total+")")
            btn_home.visibility = View.VISIBLE
        }

    }
}
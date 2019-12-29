package com.gumdi.movieaplikasi.Sign.Signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gumdi.movieaplikasi.R
import com.google.firebase.database.*
import com.gumdi.movieaplikasi.Home.HomeActivity
import com.gumdi.movieaplikasi.Sign.Signup.SignupActivity
import kotlinx.android.synthetic.main.activity_signin.*
import com.gumdi.movieaplikasi.Utils.Preferences




class SigninActivity : AppCompatActivity() {

    lateinit var iUsername :String
    lateinit var iPassword :String

    lateinit var mDatabase: DatabaseReference
    lateinit var preferences:Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

        preferences.setValues("onboarding", "1")
        if (preferences.getValues("status").equals("1")) {
            finishAffinity()

            val intent = Intent(this@SigninActivity,
                HomeActivity::class.java)
            startActivity(intent)
        }

        et_passwordsignup.setOnClickListener {
                iUsername = et_usernamesignin.text.toString()
                iPassword = et_password.text.toString()

                if (iUsername.equals("")) {
                    et_usernamesignin.error = "Silahkan tulis Username Anda"
                    et_usernamesignin.requestFocus()
                } else if (iPassword.equals("")) {
                    et_password.error = "Silahkan tulis Password Anda"
                    et_password.requestFocus()
                } else {
                    pushLogin(iUsername, iPassword)
                }
            }

        daftarbarusignin.setOnClickListener {
                var intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)

        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                } else {
                    if (user.password.equals(iPassword)){
                            preferences.setValues("nama", user.nama.toString())
                            preferences.setValues("user", user.username.toString())
                            preferences.setValues("url", user.url.toString())
                            preferences.setValues("email", user.email.toString())
                            preferences.setValues("saldo", user.saldo.toString())
                            preferences.setValues("status", "1")

                        val intent = Intent(this@SigninActivity,
                            HomeActivity::class.java)
                        startActivity(intent)
                        finishAffinity()
                    } else {
                        Toast.makeText(this@SigninActivity, "Password Anda Salah", Toast.LENGTH_LONG).show()
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SigninActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
     }

    }


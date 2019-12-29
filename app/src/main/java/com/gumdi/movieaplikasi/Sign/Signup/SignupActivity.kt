package com.gumdi.movieaplikasi.Sign.Signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.gumdi.movieaplikasi.R
import com.gumdi.movieaplikasi.Sign.Signin.User
import com.gumdi.movieaplikasi.Utils.Preferences
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    lateinit var sUsername:String
    lateinit var sPassword:String
    lateinit var sNama:String
    lateinit var sEmail:String

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference
    private lateinit var preferences: Preferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")
        preferences = Preferences(this)

        btn_pilih_bangku.setOnClickListener {
            sUsername = et_usernamesignup.text.toString()
            sPassword = et_passwordsignup.text.toString()
            sNama = et_namasignup.text.toString()
            sEmail = et_emailsignup.text.toString()

            if (sUsername.equals("")) {
                et_usernamesignup.error = "Silahkan isi Username"
                et_usernamesignup.requestFocus()
            } else if (sPassword.equals("")) {
                et_passwordsignup.error = "Silahkan isi Password"
                et_passwordsignup.requestFocus()
            } else if (sNama.equals("")) {
                et_namasignup.error = "Silahkan isi Nama"
                et_namasignup.requestFocus()
            } else if (sEmail.equals("")) {
                et_emailsignup.error = "Silahkan isi Email"
                et_emailsignup.requestFocus()
            } else {

                saveUser(sUsername, sPassword, sNama, sEmail)

            }
        }
    }

    private fun saveUser(sUsername: String, sPassword: String, sNama: String, sEmail: String) {

        val user = User()
        user.email = sEmail
        user.username = sUsername
        user.nama = sNama
        user.password = sPassword

        if (sUsername != null) {
            checkingUsername(sUsername, user)

        }

    }

    private fun checkingUsername(iUsername: String, data: User) {
        mFirebaseDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    mFirebaseDatabase.child(iUsername).setValue(data)

                    preferences.setValues("nama", data.nama.toString())
                    preferences.setValues("user", data.username.toString())
                    preferences.setValues("url", "")
                    preferences.setValues("email", data.email.toString())
                    preferences.setValues("status", "1")

                    val intent = Intent(this@SignupActivity,
                        Sigup_photoscreenActivity::class.java).putExtra("nama", data.nama)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@SignupActivity, "User sudah digunakan", Toast.LENGTH_LONG).show()

                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignupActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}

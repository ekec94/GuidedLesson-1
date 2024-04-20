// Each week you will work along with the videos to recreate the app for practice

package com.example.guidedlesson

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intValue: Int){
            Login(1),
            Password(2),
            Success(0)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    // define variables of views
        val txtLogin: EditText = findViewById(R.id.idLoginET)
        val txtPassword: EditText = findViewById(R.id.idPasswordET)
        val btnLogin: Button = findViewById(R.id.idLoginBTN)

        btnLogin.setOnClickListener {
            when (checkLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                LoginSuccess.Login -> {
                    Toast.makeText(this, getString(R.string.err_login),
                        Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.Password -> {
                    Toast.makeText(this, getString(R.string.err_pass),
                        Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }
                else -> {
                    val intent = Intent(this, Activity2::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun checkLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Emily"
        val holdPass = "password"

        if (holdLogin != txtLogin) {
            return LoginSuccess.Login
        }

        return if (holdPass != txtPassword){
            LoginSuccess.Password
        } else LoginSuccess.Success
    }
}
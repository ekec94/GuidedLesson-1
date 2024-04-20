// Each week you will work along with the videos to recreate the app for practice

package com.example.guidedlesson

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
            login(1),
            password(2),
            success(0)
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
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                LoginSuccess.login -> {
                    Toast.makeText(this, getString(R.string.err_login),
                        Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(this, getString(R.string.err_pass),
                        Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }
                else -> {Toast.makeText(this, "Success",
                    Toast.LENGTH_LONG).show()}
            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Emily"
        val holdPass = "password"

        if (holdLogin != txtLogin) {
            return LoginSuccess.login
        }

        return if (holdPass != txtPassword){
            LoginSuccess.password
        } else LoginSuccess.success
    }
}
package com.saniya.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    // Declared here [making them class variables not member variables] to widen the scope of the variable.
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView

    private val validMobileNumber = "1234567890"
    private val validPassword = arrayOf("tony", "thor", "steve", "hulk")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.title = "Log In" // To change title of the toolbar

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        // Creating object of shared preferences class
        // Why getString? Since, id returned is an integer.
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        // Gets the value of isLoggedIn key. If null, then false is stored in it.
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        /* lambda representation */
        btnLogin.setOnClickListener {

            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            val nameOfAvenger: String

            if (mobileNumber == validMobileNumber && validPassword.contains(password)) {

                nameOfAvenger = when (password) {
                    "tony" -> "Tony Starks"
                    "thor" -> "Thor"
                    "steve" -> "Steve"
                    "hulk" -> "Bruce Banner"
                    else -> "Avenger"
                }

                saveLoginPreference(nameOfAvenger) // Sets login status for the 1st time when user logs in
                val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
                startActivity(intent)
                finish()
            } else
                Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_LONG).show()
        }

        txtForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        txtRegister.setOnClickListener {
            Toast.makeText(this@LoginActivity, "Register", Toast.LENGTH_LONG).show()
        }
    }

    // This fun saves boolean value of the users's login status
    private fun saveLoginPreference(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        // instead of apply, we can also use commit but since it immediately stores the data it uses more resources, hence apply preferred
        sharedPreferences.edit().putString("title", title).apply()
    }
}

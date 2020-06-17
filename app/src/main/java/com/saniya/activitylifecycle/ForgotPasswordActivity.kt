package com.saniya.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var etOTP : EditText
    lateinit var btnGeneratePassword : Button

    val otp = "1234"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etOTP = findViewById(R.id.etOTP)
        btnGeneratePassword = findViewById(R.id.btnGeneratePassword)

        btnGeneratePassword.setOnClickListener {
            if(etOTP.text.toString() == otp)
                Toast.makeText(this@ForgotPasswordActivity,"Change password",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this@ForgotPasswordActivity,"Invalid OTP",Toast.LENGTH_LONG).show()
        }

    }
}

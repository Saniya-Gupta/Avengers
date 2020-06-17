package com.saniya.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {

    private var titleName: String? = "Avengers"
    private lateinit var etText: EditText
    private lateinit var btnSend: Button
    private lateinit var btnLogOut: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)

        titleName = sharedPreferences.getString("title", "The Avengers")
        /* Change title in toolbar */
        title = titleName

        etText = findViewById(R.id.etText)
        btnSend = findViewById(R.id.btnSend)
        btnLogOut = findViewById(R.id.btnLogOut)

        btnSend.setOnClickListener {
            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            val msgText = etText.text.toString()
            intent.putExtra("Text", msgText)
            intent.putExtra("Title", "Message")
            startActivity(intent)
        }

        btnLogOut.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this@AvengersActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    /*  override fun onStart() {
            super.onStart()
        }

        override fun onResume() {
            super.onResume()
        }
        override fun onPause() {
                  super.onPause()
              }

        override fun onStop() {
            super.onStop()
        }

        override fun onRestart() {
            super.onRestart()
        }

        override fun onDestroy() {
            super.onDestroy()
        }

  */
}




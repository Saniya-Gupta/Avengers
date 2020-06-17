package com.saniya.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MessageActivity : AppCompatActivity() {

    lateinit var txtText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        txtText = findViewById(R.id.txtText)
        if (intent != null) {
            txtText.text = intent.getStringExtra("Text")
            title = intent.getStringExtra("Title")
        }
    }
}

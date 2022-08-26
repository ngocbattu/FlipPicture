package vidu.demo.flippicture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StartGameActivity : AppCompatActivity() {
    lateinit var btnStart : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)
        btnStart = findViewById(R.id.btnStrat)
        btnStart.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@StartGameActivity,MainActivity::class.java))
        })
    }
}
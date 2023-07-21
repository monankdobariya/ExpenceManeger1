package com.example.expencemanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SpalshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)
        initview()
    }

    private fun initview() {
        Handler().postDelayed(
            {
                val i = Intent(this@SpalshActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            }, 5000
        )

    }
}

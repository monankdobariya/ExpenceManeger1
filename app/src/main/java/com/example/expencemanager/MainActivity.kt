package com.example.expencemanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expencemanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var obj: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obj=ActivityMainBinding.inflate(layoutInflater)
        setContentView(obj.root)
        initview()
    }

    private fun initview() {

        obj.crd1.setOnClickListener {

            var a = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(a)
        }

    }


}
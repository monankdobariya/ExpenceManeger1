package com.example.expencemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.expencemanager.databinding.ActivityCategoryBinding
import com.example.expencemanager.databinding.ActivityHomeBinding

class Category_Activity : AppCompatActivity() {

    lateinit var obj:ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obj = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(obj.root)
        initview()
    }

    private fun initview() {
        var database = DatabaseHelper(this, "DatabaseWord.db", null, 1)

        obj.btnapply.setOnClickListener {

            var name = obj.edtname.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Please Enter Field", Toast.LENGTH_SHORT).show()

            } else {
                database.insertData(name)
                Toast.makeText(this, " "+name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
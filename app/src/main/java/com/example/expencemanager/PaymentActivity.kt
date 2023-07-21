package com.example.expencemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expencemanager.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        var database = DatabaseHelper(this, "DatabaseWord.db", null, 1)

        binding.btnapply.setOnClickListener {

            var mode = binding.edtname.text.toString()

            if (mode.isEmpty()) {
                Toast.makeText(this, "Please Enter Field", Toast.LENGTH_SHORT).show()

            } else {
                database.modeinsertData(mode)
                Toast.makeText(this, "Enter succsesfully", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
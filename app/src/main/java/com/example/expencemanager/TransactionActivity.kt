package com.example.expencemanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanager.Adapter.AlldataAdapter
import com.example.expencemanager.Model.AllDataModel
import com.example.expencemanager.databinding.ActivityTransactionBinding

class TransactionActivity : AppCompatActivity() {


     lateinit var db1:DatabaseHelper
    lateinit var adapter:AlldataAdapter
    var Alldatalist = ArrayList<AllDataModel>()


    lateinit var binding:ActivityTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db1 = DatabaseHelper(this, "DatabaseWord.db", null, 1)

        initview()
    }

    private fun initview() {


        Alldatalist=db1.Alldatadispalay()

        val adapter = AlldataAdapter(this,Alldatalist)
        val manager = LinearLayoutManager(this@TransactionActivity, RecyclerView.VERTICAL, false)

        binding.rcvdata.setLayoutManager(manager)
        binding.rcvdata.setAdapter(adapter)


    }
}
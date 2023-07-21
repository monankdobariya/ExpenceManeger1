package com.example.expencemanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import com.example.expencemanager.Adapter.CategoryAdapter
import com.example.expencemanager.Model.CategoryModel
import com.example.expencemanager.Model.ModemodelClass
import com.example.expencemanager.databinding.ActivityIncomeBinding
import com.example.experrtmaneger.Modeadpter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class IncomeActivity : AppCompatActivity() {

    lateinit var db1: DatabaseHelper
    lateinit var c: String
    lateinit var m: String
    var categorylist = ArrayList<CategoryModel>()
    var modelist = ArrayList<ModemodelClass>()
    var time = " "


    lateinit var binding: ActivityIncomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db1 = DatabaseHelper(this, "DatabaseWord.db", null, 1)

        initview()
    }

    private fun initview() {

        val textView: TextView = findViewById(R.id.edttime)
        val simpleDateFormat = SimpleDateFormat(" hh:mm a")

        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime

        binding.edtdate.setOnClickListener {

            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    binding.edtdate.setText(dat)
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }


        binding.edttime.setOnClickListener {

            val calendar = Calendar.getInstance()
            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = calendar.get(Calendar.MINUTE)

            val textView: TextView = findViewById(R.id.edttime)


            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    val selectedTime = String.format("%02d:%02d", currentHour, minute)
                    textView.text = selectedTime
                },
                currentHour,
                currentMinute,
                false
            )

            timePickerDialog.show()

        }


        categorylist = db1.displayCategory()
        var adapter = CategoryAdapter(this, categorylist)
        binding.spinnercategory.adapter = adapter


        modelist = db1.Dispalaymode()
        var adpter = Modeadpter(this, modelist)
        binding.spinnermode.adapter = adpter



        binding.spinnercategory.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                c = categorylist[position].category
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        binding.spinnermode.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                m = modelist[position].mode
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.imgright.setOnClickListener {

            var amount = binding.edtamount.text.toString()
            var note = binding.edtnote.text.toString()
            var date=binding.edtdate.text.toString()


            db1.alldatainsert(amount, note, c, m,date)

            var i= Intent(this,TransactionActivity::class.java)
            startActivity(i)

        }


    }


}



package com.example.expencemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import com.example.expencemanager.databinding.ActivityCalanderBinding
import java.util.Calendar

class CalanderActivity : AppCompatActivity() {

    lateinit var obj: ActivityCalanderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obj= ActivityCalanderBinding.inflate(layoutInflater)
        setContentView(obj.root)
        initview()
    }

    private fun initview() {
        obj.calender
            .setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->

                    val Date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)
                })
    }
}
package com.example.expencemanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expencemanager.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    lateinit var obj: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        obj = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(obj.root)

        initview()
    }

    private fun initview() {
        obj.imgclander.setOnClickListener {
            var i = Intent(this, CalanderActivity::class.java)
            startActivity(i)
        }
        obj.imgmenu.setOnClickListener {
            obj.drawer.openDrawer(obj.navigation)
        }
        obj.layouthome.setOnClickListener {
            var i= Intent(this,HomeActivity::class.java)
            startActivity(i)
        }
        obj.layoutcalender.setOnClickListener {
            var i=Intent(this,CalanderActivity::class.java)
            startActivity(i)
        }
        obj.layoutexported.setOnClickListener {
            var i=Intent(this,Exported_reports_Activity::class.java)
            startActivity(i)
        }
        obj.layoutcategory.setOnClickListener {
            var i=Intent(this,Category_Activity::class.java)
            startActivity(i)

        }
        obj.cardincome.setOnClickListener {
            var i=Intent(this,IncomeActivity::class.java)
            startActivity(i)
        }
        obj.cardcategory.setOnClickListener {
            var i= Intent(this,Category_Activity::class.java)
            startActivity(i)
        }
        obj.layoutpayment.setOnClickListener {
            var i=Intent(this,PaymentActivity::class.java)
            startActivity(i)
        }
    }
}
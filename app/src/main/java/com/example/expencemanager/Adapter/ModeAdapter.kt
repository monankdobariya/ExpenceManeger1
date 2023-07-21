package  com.example.experrtmaneger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.expencemanager.IncomeActivity
import com.example.expencemanager.Model.ModemodelClass
import com.example.expencemanager.R

class Modeadpter(var IncomeActivity: IncomeActivity, var Modelist: ArrayList<ModemodelClass>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return Modelist.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v: View = LayoutInflater.from(IncomeActivity).inflate(R.layout.category_item_file, null)
        val Category = v.findViewById<TextView>(R.id.txtcategory)
        Category.text = Modelist[position].mode
        return v
    }

}

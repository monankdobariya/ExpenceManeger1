package com.example.expencemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.expencemanager.IncomeActivity
import com.example.expencemanager.Model.CategoryModel
import com.example.expencemanager.R

class CategoryAdapter(var incomeActivity: IncomeActivity, var categorylist: ArrayList<CategoryModel>) :
    BaseAdapter() {
    override fun getCount(): Int {

        return categorylist.size
    }

    override fun getItem(position: Int): Any? {

        return null
    }

    override fun getItemId(position: Int): Long {
        return 0

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var v:View=LayoutInflater.from(incomeActivity).inflate(R.layout.category_item_file,null)
        var category =v.findViewById<TextView>(R.id.txtcategory)
        category.text=categorylist[position].category
        return v
    }

   fun refresh(list: ArrayList<CategoryModel>)
    {
        this.categorylist=ArrayList()
        this.categorylist.addAll(categorylist)
        notifyDataSetChanged()
    }
}
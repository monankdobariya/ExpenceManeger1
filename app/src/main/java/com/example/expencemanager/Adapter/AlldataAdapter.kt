package com.example.expencemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanager.Model.AllDataModel
import com.example.expencemanager.R
import com.example.expencemanager.TransactionActivity


class AlldataAdapter(datastore1: TransactionActivity, var datastore: ArrayList<AllDataModel>): RecyclerView.Adapter<AlldataAdapter.MyviewHolder>() {


    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


        var amount:TextView=itemView.findViewById(R.id.txtamount)
        var category:TextView=itemView.findViewById(R.id.txtcategory)
        var date:TextView=itemView.findViewById(R.id.txtdate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
       var view=LayoutInflater.from(parent.context).inflate(R.layout.transaction_item_file,parent,false)

       return MyviewHolder(view)
    }

    override fun getItemCount(): Int {

        return datastore.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {


        holder.amount.text=datastore[position].amount
        holder.category.text=datastore[position].category
        holder.date.text=datastore[position].date
    }

}
package com.smartypants.smartvis

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class CustomAdapter(val userList: ArrayList<file>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//    private val python = Python.getInstance()
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: file) {
            val textViewName = itemView.findViewById(R.id.fileName) as TextView
            //val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
            textViewName.text = user.name
        }
        init {
            itemView.setOnClickListener{
                val fileName = itemView?.findViewById<TextView?>(R.id.fileName)
//                if(fileName?.text!!.contains("jpg")||fileName?.text.contains("jpeg")||fileName?.text.contains("image"))
//                {
//                    val intent = Intent(itemView.context,viewImage::class.java)
//                    Toast.makeText(itemView.context,"kslk",Toast.LENGTH_SHORT).show()
//                    val bundle = Bundle()
//                    bundle.putString("name",fileName?.text.toString())
//                    intent.putExtras(bundle)
//                    startActivity(itemView.context,intent,bundle)
//                }
//                else if(fileName?.text!!.contains("csv"))
//                {
//                    Toast.makeText(itemView.context,"A csv file",Toast.LENGTH_SHORT).show()
//
////                    if (! Python.isStarted()) {
////                        Python.start(AndroidPlatform(itemView.context));
//
////                    }
//
//                    val intent = Intent(itemView.context,viewChart::class.java)
//
//                    startActivity(itemView.context,intent,Bundle())
//                }
//                else
//                {
//                    Toast.makeText(itemView.context,"Some other file",Toast.LENGTH_SHORT).show()
//                    val intent = Intent(itemView.context,viewChart::class.java)
//                    startActivity(itemView.context,intent,Bundle())
//                }
                if(fileName?.text.toString().contains("csv")){
                    val intent = Intent(itemView.context,optionsActivity::class.java)
                    Toast.makeText(itemView.context,"kslk",Toast.LENGTH_SHORT).show()
                    val bundle = Bundle()
                    bundle.putString("name",fileName?.text.toString())
                    intent.putExtras(bundle)
                    startActivity(itemView.context,intent,bundle)
                }
                else{
                    Toast.makeText(itemView.context,"Select a .CSV file",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}



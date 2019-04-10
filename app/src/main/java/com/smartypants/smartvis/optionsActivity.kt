package com.smartypants.smartvis

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener



class optionsActivity : AppCompatActivity(){
    lateinit var listview : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.options_activity)

        val name = intent.getStringExtra("name")
        var options = arrayOf("Pie Chart", "Column Chart", "Line Chart", "Tag Cloud")
        var listadapter: ArrayAdapter<String> = ArrayAdapter(this,R.layout.activity_listview,options)

        listview = findViewById(R.id.options_list) as ListView
        listview.adapter = listadapter

        listview.setOnItemClickListener(
                AdapterView.OnItemClickListener(fun(adapter: AdapterView<*>, v: View, position: Int, arg3){
                    val item = adapter.getItemAtPosition(position)
                    val intent = Intent(listview.context,viewChart::class.java)
                    intent.putExtra("name",name)
                    intent.putExtra("type",options[position])
                    startActivity(intent)

                }))
    }
}
package com.smartypants.smartvis

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.anychart.anychart.*

import java.util.ArrayList;
import java.util.List;

class viewChart : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chart_view)
        val anyChartView : AnyChartView = findViewById(R.id.any_chart_view)
        val type = intent.getStringExtra("type")
        val name = intent.getStringExtra("name")
        if(type.contains("pie",true))
        {
            val createChartobj = pieChart()
            createChartobj.createPieChart(name,anyChartView)

        }
        else if(type.contains("bar"))
        {
            val createChartobj = pieChart()
            createChartobj.createPieChart(name,anyChartView)
        }
        else if(type.contains("column",true))
        {
            val createChartobj = columnChart()
            createChartobj.createColumnChart(name,anyChartView)
        }
        else if(type.contains("tag",true))
        {
            val createChartobj = tagCloud()
            createChartobj.createTagCloud(name,anyChartView)
        }


    }
}
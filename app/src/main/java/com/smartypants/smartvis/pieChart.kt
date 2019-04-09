package com.smartypants.smartvis

import android.util.Log
import com.anychart.anychart.*
import java.util.ArrayList

class pieChart()
{
    fun createPieChart(name: String, anyChartView : AnyChartView)
    {
        val pie : Pie = AnyChart.pie()
        val data = ArrayList<DataEntry>()
        Log.d("file path",name!!.toString().split(" ")[2].substring(14))

        val csv  = csvData(name)

        Log.d("heads", csv.head.toString())

        data.add(ValueDataEntry("John", 10000))
        data.add(ValueDataEntry("Jake", 12000))
        data.add(ValueDataEntry("Peter", 18000))
        pie.data(data)
        anyChartView.setChart(pie);
    }
}
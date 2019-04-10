package com.smartypants.smartvis

import android.util.Log
import com.anychart.anychart.*
import org.apache.commons.lang3.StringUtils
import java.util.ArrayList

class pieChart()
{
    fun createPieChart(name: String, anyChartView : AnyChartView)
    {
        val pie : Pie = AnyChart.pie()
        val data = ArrayList<DataEntry>()

        Log.d("name", name)
        val csv  = csvData(StringUtils.substringAfterLast(name.split(" ")[2].substring(14), ":"))//String manipulation to get exact path

        val headji = csv.head
        if(headji!=null){
            Log.d("heads", headji[0])
            Log.d("heads", headji[1])
        }

        val dataji = csv.dataji
        val head = csv.head
        if(head!!.size>2)
        {

        }
        if(dataji!=null){
            for(row in dataji){
                data.add(ValueDataEntry(row[0], row[1].toDouble()))
            }
        }
        Log.d("data",data.toString())
        pie.data(data)
        anyChartView.setChart(pie);
    }
}
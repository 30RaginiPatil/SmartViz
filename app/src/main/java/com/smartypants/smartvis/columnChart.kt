package com.smartypants.smartvis

import android.util.Log
import com.anychart.anychart.AnyChart.*
import com.anychart.anychart.AnyChartView
import com.anychart.anychart.DataEntry
import com.anychart.anychart.ValueDataEntry
import org.apache.commons.lang3.StringUtils
import java.util.ArrayList

class columnChart(){
 fun createColumnChart(name:String,anyChartView: AnyChartView)   {

     val cartesian = column()
     val data = ArrayList<DataEntry>()
     val csv  = csvData(StringUtils.substringAfterLast(name.split(" ")[2].substring(14), ":"))//String manipulation to get exact path

     val headji = csv.head
     if(headji!=null){
         Log.d("heads", headji[0])
         Log.d("heads", headji[1])
     }

     val dataji = csv.data
     if(dataji!=null){
         for(row in dataji){
             data.add(ValueDataEntry(row[0], row[1].toDouble()))
         }
     }

     val column = cartesian.column(data)
     anyChartView.setChart(cartesian)
 }
}
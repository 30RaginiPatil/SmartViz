package com.smartypants.smartvis

import com.anychart.anychart.AnyChart
import com.anychart.anychart.AnyChart.*
import com.anychart.anychart.AnyChartView
import com.anychart.anychart.DataEntry
import com.anychart.anychart.ValueDataEntry
import java.util.ArrayList

class columnChart(){
 fun createColumnChart(name:String,anyChartView: AnyChartView)   {

     val cartesian = column()

     val data = ArrayList<DataEntry>()
     data.add(ValueDataEntry("Rouge", 80540))
     data.add(ValueDataEntry("Foundation", 94190))
     data.add(ValueDataEntry("Mascara", 102610))
     data.add(ValueDataEntry("Lip gloss", 110430))
     data.add(ValueDataEntry("Lipstick", 128000))
     data.add(ValueDataEntry("Nail polish", 143760))
     data.add(ValueDataEntry("Eyebrow pencil", 170670))
     data.add(ValueDataEntry("Eyeliner", 213210))
     data.add(ValueDataEntry("Eyeshadows", 249980))

     val column = cartesian.column(data)



     anyChartView.setChart(cartesian)
 }
}
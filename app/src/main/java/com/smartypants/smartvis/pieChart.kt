package com.smartypants.smartvis

import com.anychart.anychart.*
import java.util.ArrayList

class pieChart()
{
    fun createPieChart(name: String, anyChartView : AnyChartView)
    {
        val pie : Pie = AnyChart.pie()
        val data = ArrayList<DataEntry>()

        data.add(ValueDataEntry("John", 10000))
        data.add(ValueDataEntry("Jake", 12000))
        data.add(ValueDataEntry("Peter", 18000))
        pie.data(data)
        anyChartView.setChart(pie);
    }
}
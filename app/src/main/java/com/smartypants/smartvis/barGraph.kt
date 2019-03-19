//package com.smartypants.smartvis
//
//import com.anychart.anychart.*
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import java.util.ArrayList
//
//class BarChartActivity: AppCompatActivity() {
//
//fun createBarGraph(name: String,anyChartView: AnyChartView) {
//
//val barChart = AnyChart.bar()
//
//barChart.setAnimation(true)
//
//barChart.setPadding(10.0, 20.0, 5.0, 20.0)
//
//.title(false)
//.separator(false)
//.displayMode(TooltipDisplayMode.SEPARATED)
//.positionMode(TooltipPositionMode.POINT)
//.useHtml(true)
//.fontSize(12.0)
//.offsetX(5.0)
//.offsetY(0.0)
//.format(
//("function() {\n" +
//"      return '<span style=\"color: #D9D9D9\">$</span>' + Math.abs(this.value).toLocaleString();\n" +
//"    }"))
//
//val seriesData = ArrayList<DataEntry>()
//seriesData.add(CustomDataEntry("Nail polish", 5376, -229))
//seriesData.add(CustomDataEntry("Eyebrow pencil", 10987, -932))
//seriesData.add(CustomDataEntry("Rouge", 7624, -5221))
//seriesData.add(CustomDataEntry("Lipstick", 8814, -256))
//seriesData.add(CustomDataEntry("Eyeshadows", 8998, -308))
//seriesData.add(CustomDataEntry("Eyeliner", 9321, -432))
//seriesData.add(CustomDataEntry("Foundation", 8342, -701))
//seriesData.add(CustomDataEntry("Lip gloss", 6998, -908))
//seriesData.add(CustomDataEntry("Mascara", 9261, -712))
//seriesData.add(CustomDataEntry("Shampoo", 5376, -9229))
//seriesData.add(CustomDataEntry("Hair conditioner", 10987, -13932))
//seriesData.add(CustomDataEntry("Body lotion", 7624, -10221))
//seriesData.add(CustomDataEntry("Shower gel", 8814, -12256))
//seriesData.add(CustomDataEntry("Soap", 8998, -5308))
//seriesData.add(CustomDataEntry("Eye fresher", 9321, -432))
//seriesData.add(CustomDataEntry("Deodorant", 8342, -11701))
//seriesData.add(CustomDataEntry("Hand cream", 7598, -5808))
//seriesData.add(CustomDataEntry("Foot cream", 6098, -3987))
//seriesData.add(CustomDataEntry("Night cream", 6998, -847))
//seriesData.add(CustomDataEntry("Day cream", 5304, -4008))
//seriesData.add(CustomDataEntry("Vanila cream", 9261, -712))
//
//val set = Set.instantiate()
//set.data(seriesData)
//val series1Data = set.mapAs("{ x: 'x', value: 'value' }")
//val series2Data = set.mapAs("{ x: 'x', value: 'value2' }")
//
//val series1 = barChart.bar(series1Data)
//series1.name("Females")
//.color("HotPink")
//series1.tooltip()
//.position("right")
//.anchor(Anchor.LEFT_CENTER)
//
//val series2 = barChart.bar(series2Data)
//series2.name("Males")
//series2.tooltip()
//.position("left")
//.anchor(Anchor.RIGHT_CENTER)
//
//barChart.setLegend(true)
//barChart.setLegend(true)
//
//
//anyChartView.setChart(barChart)
//}
//
//    private inner class CustomDataEntry internal constructor(x:String, value:Number, value2:Number):ValueDataEntry(x, value) {
//        init{
//            setValue("value2", value2)
//        }
//    }
//}

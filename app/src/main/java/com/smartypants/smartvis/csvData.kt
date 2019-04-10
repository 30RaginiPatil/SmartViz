package com.smartypants.smartvis

import android.util.Log
import com.opencsv.CSVReader
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

class csvData(val name: String)
{
    val filePath : String = name
    var head : Array<String>? = null
    var data : List<Array<String>>? = null
    init{
        Log.d("csvcsv", "read call")
        try{
            Log.d("csvdata", "trying to open file"+filePath)

            val csvHeadReader = CSVReader(FileReader(filePath), ',', '"', 0)
            head = csvHeadReader.readNext()
            val csvReader = CSVReader(FileReader(filePath), ',', '"', 1)

            data = csvReader.readAll()
            val dataji = data
            if(dataji!=null) {
                Log.d("csvdata", "data not null")

                for (row in dataji) {
                    Log.d("csvdata", Arrays.toString(row))
                }
//                head = dataji.get(0)
            }
        }
        catch (e: Exception)
        {
            Log.d("csvdata", e.toString());
            Log.d("csvdata", "OOps can't")
        }
    }
}
//2019-04-10 01:32:52.300 26797-26797/com.smartypants.smartvis D/file path: com.android.providers.downloads.documents/document/raw:/storage/emulated/0/Download/yourcsvFile.csv
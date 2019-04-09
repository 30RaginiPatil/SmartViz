package com.smartypants.smartvis

import com.opencsv.CSVReader
import java.io.BufferedReader
import java.io.FileReader

class csvData(val name: String)
{
    val filePath : String = name
    var head : Array<String>? = null

    public fun read()
    {
        var b : BufferedReader? = null
        var csvReader: CSVReader? =null
        try{

            b = BufferedReader(FileReader(filePath))
            csvReader = CSVReader(b)

            head = csvReader.readNext()


        }
        catch (e: Exception)
        {

        }
    }

    private fun getHeadData(): Array<String>? {

        return head
    }
}
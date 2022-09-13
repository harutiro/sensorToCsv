package net.harutiro.helloandroid

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.PrintWriter

class OtherFileStorage(context: Context){

    private val fileAppend : Boolean = true //true=追記, false=上書き
    private var fileName : String = "SensorLog"
    private val extension : String = ".csv"

    //内部ストレージのDocumentのURL
    val filePath: String = context.getApplicationContext()                        //   コンテキスト
                            .getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) // ドキュメントフォルダー (外部ファイル)
                            .toString().plus("/")                           //  文字化
                            .plus(fileName).plus(extension)                       // ファイル名


    //受け取った文字列をそのまま保存するだけの関数
    fun writeText(text:String){
        val fil = FileWriter(filePath,fileAppend)
        val pw = PrintWriter(BufferedWriter(fil))
        pw.println(text)
        pw.close()
    }
}

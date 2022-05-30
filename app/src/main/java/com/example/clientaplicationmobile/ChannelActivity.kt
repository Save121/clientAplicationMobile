package com.example.clientaplicationmobile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient.FileChooserParams.parseResult
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChannelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel)
        val addNewFileButton: FloatingActionButton = findViewById(R.id.addNewFileButton)



        addNewFileButton.setOnClickListener() {
            addNewFile()

        }
    }



    private fun addNewFile(
        name: String = "Undefined",
        size: Double = 0.0,
        nameCreator: String = "Lesman"
    ) {
        val fileCard = layoutInflater.inflate(R.layout.file_card, null)
        val fileName: TextView = fileCard.findViewById(R.id.fileName)
        fileName.text = name
        val fileCreator: TextView = fileCard.findViewById(R.id.nameCreator)
        fileCreator.text = nameCreator

        val fileList: LinearLayout = findViewById(R.id.filesList)
        fileList.addView(fileCard)
    }
}
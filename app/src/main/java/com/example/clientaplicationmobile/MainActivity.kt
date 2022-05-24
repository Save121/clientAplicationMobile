package com.example.clientaplicationmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val addChannelButton: FloatingActionButton = findViewById(R.id.addChannelButton)

            addChannelButton.setOnClickListener {addNewChannel()}

        }

    private fun addNewChannel() {
        this.appendChannel("And")
    }

    private fun appendChannel(name:String = "undefined",nameCreator:String = "anonymous" ){
        val channelCard: View = layoutInflater.inflate(R.layout.channel_card, null)
       val channelName: TextView = channelCard.findViewById(R.id.channelName)
        channelName.text = name
        val channelCreator: TextView = channelCard.findViewById(R.id.channelCreator)
        channelCreator.text = nameCreator

        val channelList: LinearLayout = findViewById(R.id.channelList)

        channelList.addView(channelCard)
    }


}
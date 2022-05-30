package com.example.clientaplicationmobile

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.DataOutputStream
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addChannelButton: FloatingActionButton = findViewById(R.id.addChannelButton)
        addChannelButton.setOnClickListener { addNewChannel() }



    }

    private fun addNewChannel() {

        Thread(Runnable {
            val socket = Socket("10.0.2.2", 3333)
            val msg = "Ese soy io"
            val bytesResult = msg.toByteArray()

            val prue = socket.getOutputStream()
            prue.write(bytesResult)


        }).start()
        val builder = AlertDialog.Builder(this)
        val addChannelModal = layoutInflater.inflate(R.layout.add_channel_modal, null)
        builder.setView(addChannelModal)

        val modalView = builder.create()
        modalView.show()

        val createChannelButton: Button = addChannelModal.findViewById(R.id.createChannelButton)

        createChannelButton.setOnClickListener() {
            val channelName: TextView = addChannelModal.findViewById(R.id.channelName)
            this.appendChannel(channelName.text.toString())
            modalView.cancel()
        }

    }

    private fun appendChannel(name: String = "undefined", nameCreator: String = "anonymous") {
        val channelCard = layoutInflater.inflate(R.layout.channel_card, null)
        val channelName: TextView = channelCard.findViewById(R.id.channelName)
        channelName.text = name
        val channelCreator: TextView = channelCard.findViewById(R.id.channelCreator)
        channelCreator.text = nameCreator

        val channelList: LinearLayout = findViewById(R.id.channelList)

        channelList.addView(channelCard)
    }


}
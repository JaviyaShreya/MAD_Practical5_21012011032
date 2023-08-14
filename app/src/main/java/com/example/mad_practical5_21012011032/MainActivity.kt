package com.example.mad_practical5_21012011032

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Browser
import android.provider.ContactsContract.DisplayPhoto
import android.telecom.Call
import android.widget.Button
import android.widget.EditText
import android.widget.Gallery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnBrowser:Button=findViewById(R.id.buttonBrowser)
        val editBrowser:EditText=findViewById(R.id.editTextBrowser)
        btnBrowser.setOnClickListener {
            Browser(editBrowser.text.toString())
        }
        val btnCall:Button = findViewById(R.id.buttonCall)
        val editCall:EditText=findViewById(R.id.editTextCall)
        btnCall.setOnClickListener(){
            call(editCall.text.toString())
        }
        val btnCallLog:Button=findViewById(R.id.buttonCallLog)
        btnCallLog.setOnClickListener(){
            call(editCall.text.toString())
        }
        val btnGallery:Button=findViewById(R.id.buttonGallery)
        btnGallery.setOnClickListener(){
        }
    }
    fun Browser(url:String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun call(number:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also{startActivity(it)}
    }
    fun calllog(number: Number){
        Intent(Intent.ACTION_VIEW).setData(Uri.parse("tel:$number")).also { startActivity(it) }
    }
    fun gallery(photo: DisplayPhoto){
        Intent(Intent.ACTION_VIEW, Uri.parse(gallery)).also { startActivity(it) }
    }
}

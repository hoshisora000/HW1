package com.example.hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button)
        button1.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            var input_name = findViewById<EditText>(R.id.name).text
            var input_phone = findViewById<EditText>(R.id.phone).text

            val bundle=Bundle()
            bundle.putString("inf1",input_name.toString())
            bundle.putString("inf2",input_phone.toString())

            intent.putExtras(bundle)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let{
            if(requestCode==1&&resultCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.show_inf).text=
                    "姓名: ${it.getString("inf1")}\n\n"+
                    "電話: ${it.getString("inf2")}\n\n"+
                    "飲料: ${it.getString("inf3")}\n\n"+
                    "甜度: ${it.getString("inf4")}\n\n"+
                    "冰塊: ${it.getString("inf4")}\n\n"
            }
        }
    }
}
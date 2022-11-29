package com.example.pr23kargin

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : GestureProcessing() {
    private lateinit var tvTitle : TextView
    private lateinit var tvName : TextView
    private lateinit var tvAge : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTitle = findViewById(R.id.tvTitle)
        tvName = findViewById(R.id.tbName)
        tvAge = findViewById(R.id.tbAge)
        tvTitle.text = "Заголовок"
        defineGDC(this)
    }

    override fun onSwipeLeft() {
       startActivity(Intent(this, MainActivity2::class.java))
    }
    fun onClick(view :View){
        when(view.id){
            R.id.btn -> {
                val name1: String = tvName.text.toString()
                val age1: Int = tvAge.text.toString().toInt()

                val db = baseContext.openOrCreateDatabase("app.db", MODE_PRIVATE, null)

                val values = ContentValues()

                db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER, UNIQUE(name))")
                db.execSQL("INSERT OR IGNORE INTO users VALUES ( '$name1', $age1);")
                //values.put(name, age2);
                //values.put(name, age2);
                db.close()
                tvTitle.text = "Запись добавлена"

            }

        }
    }

}
package com.example.pr23kargin
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity2 : GestureProcessing() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView = findViewById(R.id.textView2)
        defineGDC(this)
    }

    override fun onSwipeRight() {
        startActivity(Intent(this, MainActivity::class.java))
    }
    fun onClick(view : View){
        val db = baseContext.openOrCreateDatabase("app.db", MODE_PRIVATE, null)
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER, UNIQUE(name))")
        db.execSQL("INSERT OR IGNORE INTO users VALUES ('', 22), ('', 31), (' ', 28);")
        val query: Cursor = db.rawQuery("SELECT * FROM users;", null)
        textView.text = ""
        var totalString :String = ""
        while (query.moveToNext()) {
            val name: String = query.getString(0)
            val age: Int = query.getInt(1)
            totalString= totalString + "Name: $name Age: $age\n"
        }
        Log.e("zhopa", totalString)
        textView.text = totalString

        query.close()
        db.close()
    }
}
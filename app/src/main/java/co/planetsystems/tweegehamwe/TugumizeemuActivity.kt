package co.planetsystems.tweegehamwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class TugumizeemuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugumizeemu)

        //accessing our textview from layout
        val textView = findViewById<TextView>(R.id.tuzekwega)

        textView.setOnClickListener{
            Toast.makeText(this@TugumizeemuActivity, R.string.text_on_click, Toast.LENGTH_LONG).show()
            val intent = Intent(baseContext,TwegeHamwe::class.java)
            startActivity(intent)
        }
    }

    }

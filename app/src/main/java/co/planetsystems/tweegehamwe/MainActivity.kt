package co.planetsystems.tweegehamwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.yeyonyereyoBtn)

        button1.setOnClickListener {

            Toast.makeText(this,"MAAMA NAYEGYESA",Toast.LENGTH_SHORT).show()

            val intent = Intent(baseContext, TugumizeemuActivity::class.java);
            startActivity(intent);
        }
    }
}
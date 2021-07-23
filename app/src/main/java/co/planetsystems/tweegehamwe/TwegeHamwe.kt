package co.planetsystems.tweegehamwe

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class TwegeHamwe : AppCompatActivity() {
    private val sharedPrefFile = "TwegeHamwesharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twege_hamwe)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)

        var editTextTekamu = findViewById<EditText>(R.id.tekamu)
        var btnLoko = findViewById<Button>(R.id.loko)
        var textViewEbyarugamu = findViewById<TextView>(R.id.ebyarugamu)
        var btnSindika = findViewById<Button>(R.id.tugabane)

        var ekigambo: String = editTextTekamu.getText().toString()
        Log.d("CHECK RESULT : ", " $ekigambo")

        btnLoko.setOnClickListener{
           ekigambo = editTextTekamu.getText().toString()
            textViewEbyarugamu.text = ekigambo
        }

        btnSindika.setOnClickListener{
            val bahwa =Intent(baseContext,Tubashamaze::class.java)
            startActivity(bahwa)
            val editor: SharedPreferences.Editor =  sharedPreferences.edit()
                editor.putString("twayegaki",ekigambo)
            editor.apply()
            editor.commit()

        }

    }
}


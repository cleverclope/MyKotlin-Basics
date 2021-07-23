package co.planetsystems.tweegehamwe

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import co.planetsystems.tweegehamwe.workers.NotificationRequestWorker
import java.util.concurrent.TimeUnit

class Tubashamaze : AppCompatActivity() {
    private val sharedPrefFile = "TwegeHamwesharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tubashamaze)

        val ekitwayegaErizooba = findViewById<TextView>(R.id.reeba)

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val ekitwayega = sharedPreferences.getString("twayegaki", "")

        ekitwayegaErizooba.setText("${ekitwayega}").toString()

        scheduleRepeatingTasks()

    }

    private fun scheduleRepeatingTasks() {
        /*Setting up different constraints on the work request. */
        val constraints = Constraints.Builder().apply {
            setRequiredNetworkType(NetworkType.CONNECTED)
            setRequiresCharging(true)
            setRequiresStorageNotLow(true)
        }.build()

        /*Build up an obejct of PeriodicWorkRequestBuilder */
        val repeatingWork = PeriodicWorkRequestBuilder<NotificationRequestWorker>(
            1,
            TimeUnit.DAYS
        ).setConstraints(constraints)
            .build()

        /*Enqueue the work request to an instance of Work Manager */
        WorkManager.getInstance(this).enqueue(repeatingWork)
    }
}

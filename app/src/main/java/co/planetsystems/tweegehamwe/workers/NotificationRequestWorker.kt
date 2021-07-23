package co.planetsystems.tweegehamwe.workers

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.*
import co.planetsystems.tweegehamwe.R
import java.util.concurrent.TimeUnit
/* Creating Worker to deffine the task*/
class NotificationRequestWorker(val context: Context, workerParameters: WorkerParameters): Worker(context,workerParameters){

    /* Overriding the doWork to enable background running on the thread */
    override fun doWork(): Result {
       /*work to do*/
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
        val notification = NotificationCompat.Builder(context, "first").apply {
            setContentTitle("Background Task")
            setContentText("Simple Text")
            setSmallIcon(R.drawable.ic_launcher_background)
            priority = NotificationCompat.PRIORITY_DEFAULT
        }.build()

        nm.notify(System.currentTimeMillis().toInt(),notification)
        return Result.success()
    }


}
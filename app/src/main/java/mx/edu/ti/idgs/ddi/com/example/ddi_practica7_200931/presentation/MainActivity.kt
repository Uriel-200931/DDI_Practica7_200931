
package mx.edu.ti.idgs.ddi.com.example.ddi_practica7_200931.presentation



import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.activity.ComponentActivity
import mx.edu.ti.idgs.ddi.com.example.ddi_practica7_200931.R


import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    private var mHandler: Handler? = null
    private var mRunnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHandler = Handler()
        mRunnable = Runnable {
            updateTime()
            mRunnable?.let { mHandler?.postDelayed(it, 1000) }
        }

    }

    private fun updateTime() {
        val timeTextView = findViewById<TextView>(R.id.HoraParaVisualizar)

        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

        timeTextView.text = currentTime
    }
    override fun onResume() {
        super.onResume()
        mRunnable?.let { mHandler?.post(it) }
    }

    override fun onPause() {
        super.onPause()
        mRunnable?.let { mHandler?.removeCallbacks(it) }
    }


}
package machikawa.hidemasa.techacademy.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra("RESULT",0.00f)

        if (result.isInfinite()) {
            resultTextView.text = "無効な値"
        } else {
            resultTextView.text = String.format("%.2f", result).toString()
        }
    }
}

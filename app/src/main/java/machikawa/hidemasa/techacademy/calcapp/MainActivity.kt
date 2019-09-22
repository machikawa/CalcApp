package machikawa.hidemasa.techacademy.calcapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(),View.OnClickListener {

    var value1: Float = 0f
    var value2: Float = 0f
    var result: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1.setHint("数値を入力してください")
        editText2.setHint("数値を入力してください")

        plusBtn.setOnClickListener(this)
        minusBtn.setOnClickListener(this)
        multiBtn.setOnClickListener(this)
        divBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        try {
            this.value1 = editText1.text.toString().toFloat()
            this.value2 = editText2.text.toString().toFloat()

            Log.d("CALCULATIONAPP", this.value1.toString() + "の値を検知しました")
            Log.d("CALCULATIONAPP", this.value2.toString() + "の値を検知しました")
            val intent = Intent(this, Result::class.java)

            if (v.id == R.id.plusBtn) {
                this.result = this.value1 + this.value2
            } else if (v.id == R.id.minusBtn) {
                this.result = this.value1 - this.value2
            } else if (v.id == R.id.multiBtn) {
                this.result = this.value1 * this.value2
            } else if (v.id == R.id.divBtn) {
                this.result = this.value1 / this.value2
            }

            intent.putExtra("RESULT", this.result)
            startActivity(intent)

        } catch (e:Exception) {
            Log.d("CALCULATIONAPP", "例外です")
            Snackbar.make(v,"値を入力してください",Snackbar.LENGTH_LONG).show()
        }
    }
}
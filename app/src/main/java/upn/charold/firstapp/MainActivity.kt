package upn.charold.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTitle("CounterApp")

        // get reference to txt
        val txtClick = findViewById<TextView>(R.id.txt_click)
        // get reference to button
        val btnClick = findViewById<Button>(R.id.btn_click)
        val btnNext = findViewById<Button>(R.id.btn_birthday_activity)

        var timesClicked = 0
        // set on-click listener
        btnClick.setOnClickListener {
        // your code to perform when the user clicks on the button
            timesClicked += 1
            Toast.makeText(
            this, "You clicked me.", Toast.LENGTH_SHORT
            ).show()
            txtClick.text = "Clicks: $timesClicked"
        }

        btnNext.setOnClickListener{
            startActivity(Intent(this, BirthdayActivity::class.java))
        }

    }
}
package upn.charold.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.title = "CounterApp"

        // Counter app functionality
        counterClick()

        // Other activities functionality
        otherActivities()

    }

    /**
     * All counter clicks functionality
     */
    @SuppressLint("SetTextI18n")
    private fun counterClick() {
        // get reference to txt
        val txtClick = findViewById<TextView>(R.id.txt_click)
        // get reference to button
        val btnClick = findViewById<Button>(R.id.btn_click)

        var timesClicked = 0

        // set on-click listener
        btnClick.setOnClickListener {
            // your code to perform when the user clicks on the button
            timesClicked += 1

            Toast.makeText(
                this, "You clicked me.", Toast.LENGTH_SHORT
            ).show()

            val htmlClicksText = "<b>Clicks: </b> $timesClicked"
            txtClick.text = HtmlCompat.fromHtml(htmlClicksText,HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    /**
     * 'Other activities' button redirections
     */
    private fun otherActivities() {
        // Button activity actions
        val btnBirthday = findViewById<Button>(R.id.birthday_act_btn)
        val btnDice = findViewById<Button>(R.id.dice_act_btn)

        btnBirthday.setOnClickListener{
            changeActivity("Birthday")
        }
        btnDice.setOnClickListener{
            changeActivity("Dice")
        }
    }

    /**
     * Change to the specified activity
     */
    private fun changeActivity(nameActivity: String) {
        when(nameActivity){
            "Birthday" -> startActivity(Intent(this, BirthdayActivity::class.java))
            "Dice" -> startActivity(Intent(this, DiceRollerActivity::class.java))
            else -> throw IllegalArgumentException("Insert a correct parameter with an activity name")
        }
    }

}
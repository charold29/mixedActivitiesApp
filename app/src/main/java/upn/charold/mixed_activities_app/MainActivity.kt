package upn.charold.mixed_activities_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import upn.charold.mixed_activities_app.birthday_card.BirthdayActivity
import upn.charold.mixed_activities_app.cooking_converter.CookConvActivity
import upn.charold.mixed_activities_app.databinding.ActivityMainBinding
import upn.charold.mixed_activities_app.tip_calculator.CalculatorActivity
import upn.charold.mixed_activities_app.dice_roller.DiceRollerActivity
import upn.charold.mixed_activities_app.lemonade_app.LemonadeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        styles()

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
        val txtClickCounter = binding.txtClickCounter
        // get reference to button
        val btnClickCounter = binding.btnClickCounter

        var timesClicked = 0

        // set on-click listener
        btnClickCounter.setOnClickListener {
            // your code to perform when the user clicks on the button
            timesClicked += 1

            Toast.makeText(
                this, "You clicked me.", Toast.LENGTH_SHORT
            ).show()

            val htmlClicksText = "<b>Clicks: </b> $timesClicked"
            txtClickCounter.text = HtmlCompat.fromHtml(htmlClicksText,HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    /**
     * 'Other activities' button redirections
     */
    private fun otherActivities() {
        // Button activity actions
        val btnBirthday = binding.birthdayCardActivity
        val btnDice = binding.diceRollerActivity
        val btnLemonade = binding.lemonadeApp
        val btnTipCalculator = binding.tipCalculatorActivity
        val btnCookConverter = binding.cookingConverterActivity

        btnBirthday.setOnClickListener{
            changeActivity("Birthday")
        }
        btnDice.setOnClickListener{
            changeActivity("Dice")
        }
        btnLemonade.setOnClickListener{
            changeActivity("Lemonade App")
        }
        btnTipCalculator.setOnClickListener{
            changeActivity("Tip Calculator")
        }
        btnCookConverter.setOnClickListener {
            changeActivity("Cook Converter")
        }

    }

    /**
     * Change to the specified activity
     */
    private fun changeActivity(nameActivity: String) {
        when(nameActivity){
            "Birthday" -> startActivity(Intent(this, BirthdayActivity::class.java))
            "Dice" -> startActivity(Intent(this, DiceRollerActivity::class.java))
            "Lemonade App" -> startActivity(Intent(this, LemonadeActivity::class.java))
            "Tip Calculator" -> startActivity(Intent(this, CalculatorActivity::class.java))
            "Cook Converter" -> startActivity(Intent(this, CookConvActivity::class.java))
            else -> throw IllegalArgumentException("Insert a correct parameter with an activity name")
        }
    }

    private fun styles() {
        // Color
        val activityColor = ContextCompat.getColor(this, R.color.purple_700)
        // Background ActionBar Color
        val actionBar = this.supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(activityColor))
        // StatusBar Color
        window.statusBarColor = activityColor
    }

}
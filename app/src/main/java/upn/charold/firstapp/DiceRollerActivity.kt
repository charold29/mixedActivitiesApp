package upn.charold.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import upn.charold.firstapp.model.Dice

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class DiceRollerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        this.setTitle("DiceRollerApp")

        val rollButton: Button = findViewById(R.id.roll_btn)

        rollButton.setOnClickListener {
            toast()
            rollDice()
        }

    }

    /**
     * Create toast for dice roll.
     */
    private fun toast() {
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toast.show()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.rollNumber_txt)
        resultTextView.text = diceRoll.toString()
    }

}
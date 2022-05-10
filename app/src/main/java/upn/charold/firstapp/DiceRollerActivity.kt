package upn.charold.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        this.title = "DiceRollerApp"

        val rollButton: Button = findViewById(R.id.roll_btn)

        rollButton.setOnClickListener {
            toast()
            rollDice()
        }
        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Create toast for dice roll.
     */
    private fun toast() {
        val toast = Toast.makeText(this, "Dices Rolled!", Toast.LENGTH_SHORT)
        toast.show()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(6)

        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        // Find the ImageView in the layout
        val diceImage:ImageView = findViewById(R.id.dice1_img)
        val diceImage2:ImageView = findViewById(R.id.dice2_img)

        // Determine which drawable resource ID to use based on the dice roll
        val resourceImage = determineDrawable(diceRoll)
        val resourceImage2 = determineDrawable(diceRoll2)


        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(resourceImage)
        diceImage2.setImageResource(resourceImage2)
        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

    }

    private fun determineDrawable( dice: Int ): Int {
        // Determine which drawable resource ID to use based on the dice roll
        val resourceImage = when(dice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else ->  R.drawable.dice_6
        }
        return resourceImage
    }

}
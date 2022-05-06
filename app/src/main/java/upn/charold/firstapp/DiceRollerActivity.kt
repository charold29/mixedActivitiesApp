package upn.charold.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import upn.charold.firstapp.model.Dice

class DiceRollerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        this.setTitle("DiceRollerApp")

        val rollButton: Button = findViewById(R.id.roll_btn)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            val resultTextView: TextView = findViewById(R.id.rollNumber_txt)
            val dice1 = Dice(6)
            resultTextView.text = dice1.roll().toString()
        }

    }

}
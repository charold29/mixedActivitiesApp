package upn.charold.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DiceRollerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)
        this.setTitle("DiceRollerApp")
    }

}
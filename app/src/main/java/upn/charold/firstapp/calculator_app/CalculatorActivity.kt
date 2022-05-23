package upn.charold.firstapp.calculator_app

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import upn.charold.firstapp.R

class CalculatorActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        styles()
    }

    private fun styles() {
        // Color
        val color = ContextCompat.getColor(this, R.color.metallic_seaweed)
        // Title
        this.title = "Tip Calculator"
        // Background ActionBar Color
        val actionBar = this.supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(color))
    }

}
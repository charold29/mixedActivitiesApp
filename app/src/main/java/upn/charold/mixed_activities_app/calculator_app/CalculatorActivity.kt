package upn.charold.mixed_activities_app.calculator_app

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import upn.charold.mixed_activities_app.R
import upn.charold.mixed_activities_app.databinding.ActivityCalculatorBinding
import java.text.NumberFormat
import kotlin.math.ceil

class CalculatorActivity : AppCompatActivity(){

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        styles()


        binding.calculateButton.setOnClickListener{
            calculateTip()
        }

    }


    private fun calculateTip() {

        val stringInTextField = binding.costOfService.text.toString()

        val cost = stringInTextField.toDoubleOrNull()
        // If the cost is null or 0, then display 0 tip and exit this function early.
        if (cost == null || cost == 0.0) {
            binding.tipResult.text = ""
            return
        }
        val tipPercentage = getSelectedPercent()

        var tip = tipPercentage * cost

        if (binding.roundUpSwitch.isChecked) {
            tip = ceil(tip)
        }

        // Display the formatted tip value on screen
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }

    private fun getSelectedPercent(): Double{
        return when(binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
    }

    private fun styles() {
        // Color
        val activityColor = ContextCompat.getColor(this, R.color.metallic_seaweed)
        // Title
        this.title = "Tip Calculator"
        // Background ActionBar Color
        val actionBar = this.supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(activityColor))
        // StatusBar Color
        window.statusBarColor = activityColor
    }

}
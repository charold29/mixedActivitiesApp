package upn.charold.mixed_activities_app.tip_calculator

import android.content.Context
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import upn.charold.mixed_activities_app.R
import upn.charold.mixed_activities_app.databinding.ActivityCalculatorBinding
import java.text.NumberFormat
import kotlin.math.ceil

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        styles()

        binding.calculateButton.setOnClickListener { calculateTip() }

        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(view, keyCode)
        }

    }


    private fun calculateTip() {

        val stringInTextField = binding.costOfServiceEditText.text.toString()

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

    private fun getSelectedPercent(): Double {
        return when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
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
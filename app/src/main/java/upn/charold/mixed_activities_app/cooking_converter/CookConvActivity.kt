package upn.charold.mixed_activities_app.cooking_converter

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlin.math.round
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import upn.charold.mixed_activities_app.R
import upn.charold.mixed_activities_app.cooking_converter.utils.Decimal
import upn.charold.mixed_activities_app.databinding.ActivityCookConvBinding

class CookConvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCookConvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCookConvBinding.inflate(layoutInflater)
        setContentView(binding.root)
        styles()

        val inputTextWatcher: TextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                convertGramsToCups()
                convertMillilitersToFluidOunces()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        }

        binding.amountOfGrams.addTextChangedListener(inputTextWatcher)
        binding.amountOfMilliliters.addTextChangedListener(inputTextWatcher)

    }

    @SuppressLint("SetTextI18n")
    private fun convertGramsToCups() {

        val gramsInTextField = binding.amountOfGrams.text.toString()
        val grams = gramsInTextField.toDoubleOrNull()

        if (grams == null || grams == 0.0) {
            binding.conversionCups.text = "0 cups"
            return
        }

        val result = grams * 0.004226752838
        val roundedResult = result.round(2)
        val fractionResult: String

        // For fraction
        val intPart = Decimal(roundedResult).parteEntera
        val fractionPart = Decimal(roundedResult).fraction

        fractionResult = if (fractionPart == "+1") {
            " or ${intPart+1} oz"
        }else{
            " or $intPart "
                .plus(fractionPart)
                .plus(" oz")
        }

        // Display result on screen
        binding.conversionCups.text = "$roundedResult cups"
        binding.conversionCupsFraction.text = fractionResult

    }

    @SuppressLint("SetTextI18n")
    private fun convertMillilitersToFluidOunces() {

        val millilitersToTextField = binding.amountOfMilliliters.text.toString()
        val milliliters = millilitersToTextField.toDoubleOrNull()

        if (milliliters == null || milliliters == 0.0) {
            binding.conversionFluidOunces.text = "0 fluid ounces"
            return
        }

        val result = milliliters * 0.033814
        val roundedResult = result.round(2)
        val fractionResult: String

        // For fraction
        val intPart = Decimal(roundedResult).parteEntera
        val fractionPart = Decimal(roundedResult).fraction

        fractionResult = if (fractionPart == "+1") {
            " or ${intPart+1} oz"
        }else{
            " or $intPart "
                .plus(fractionPart)
                .plus(" oz")
        }

        // Display result on screen
        binding.conversionFluidOunces.text = "$roundedResult oz"
        binding.conversionFluidOuncesFraction.text = fractionResult

    }

    private fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }

    private fun styles() {
        // Color
        val activityColor = ContextCompat.getColor(this, R.color.chocolate_web)
        // Title
        this.title = "Cooking Converter"
        // Background ActionBar Color
        val actionBar = this.supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(activityColor))
        // StatusBar Color
        window.statusBarColor = activityColor
    }
}
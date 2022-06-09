package upn.charold.mixed_activities_app.lemonade_app

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.google.android.material.snackbar.Snackbar
import upn.charold.mixed_activities_app.R
import upn.charold.mixed_activities_app.lemonade_app.model.LemonTree


private const val LEMONADE_STATE = "LEMONADE_STATE"
private const val LEMON_SIZE = "LEMON_SIZE"
private const val SQUEEZE_COUNT = "SQUEEZE_COUNT"
// SELECT represents the "pick lemon" state
private const val SELECT = "select"
// SQUEEZE represents the "squeeze lemon" state
private const val SQUEEZE = "squeeze"
// DRINK represents the "drink lemonade" state
private const val DRINK = "drink"
// RESTART represents the state where the lemonade has been drunk and the glass is empty
private const val RESTART = "restart"

class LemonadeActivity : AppCompatActivity() {

    /**
     * DO NOT ALTER ANY VARIABLE OR VALUE NAMES OR THEIR INITIAL VALUES.
     *
     * Anything labeled var instead of val is expected to be changed in the functions but DO NOT
     * alter their initial values declared here, this could cause the app to not function properly.
     */

    // Default the state to select
    private var lemonadeState = "select"
    // Default lemonSize to -1
    private var lemonSize = -1
    // Default the squeezeCount to -1
    private var squeezeCount = -1

    private var lemonTree = LemonTree()
    private var lemonImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lemonade)

        // Style for ActionBar y TextColor
        styles()

        // === DO NOT ALTER THE CODE IN THE FOLLOWING IF STATEMENT ===
        if (savedInstanceState != null) {
            lemonadeState = savedInstanceState.getString(LEMONADE_STATE, "select")
            lemonSize = savedInstanceState.getInt(LEMON_SIZE, -1)
            squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, -1)
        }
        // === END IF STATEMENT ===

        lemonImage = findViewById(R.id.image_lemon_state)
        setViewElements()
        lemonImage!!.setOnClickListener {
            clickLemonImage()
        }
        lemonImage!!.setOnLongClickListener {
            showSnackbar()
        }
    }

    /**
     * === DO NOT ALTER THIS METHOD ===
     *
     * This method saves the state of the app if it is put in the background.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(LEMONADE_STATE, lemonadeState)
        outState.putInt(LEMON_SIZE, lemonSize)
        outState.putInt(SQUEEZE_COUNT, squeezeCount)
        super.onSaveInstanceState(outState)
    }

    /**
     * Clicking will elicit a different response depending on the state.
     * This method determines the state and proceeds with the correct action.
     */
    private fun clickLemonImage() {

        @Suppress("DEPRECATION")
        when(lemonadeState) {
            SELECT -> {
                lemonadeState = SQUEEZE
                lemonSize = lemonTree.pick()
                squeezeCount = 0
            }
            SQUEEZE -> {
                squeezeCount++
                lemonSize--
                if (lemonSize == 0) {
                    lemonadeState = DRINK
                    lemonSize = -1
                }
            }
            DRINK -> {
                lemonadeState = RESTART
                lemonSize = -1
            }
            RESTART -> lemonadeState = SELECT
        }

        setViewElements()

    }

    /**
     * Set up the view elements according to the state.
     */
    @SuppressLint("SetTextI18n")
    private fun setViewElements() {
        val textAction: TextView = findViewById(R.id.text_action)
        val textSqueezesCounter: TextView = findViewById(R.id.squeeze_counter)

        when (lemonadeState){
            SELECT -> {
                textAction.setText(R.string.lemon_select)
                lemonImage?.setImageResource(R.drawable.lemon_tree)
            }
            SQUEEZE -> {
                textAction.setText(R.string.lemon_squeeze)
                lemonImage?.setImageResource(R.drawable.lemon_squeeze)
                textSqueezesCounter.text = "You still have $lemonSize squeezes left"
            }
            DRINK -> {
                textAction.setText(R.string.lemon_drink)
                lemonImage?.setImageResource(R.drawable.lemon_drink)
                textSqueezesCounter.text = ""
            }
            RESTART -> {
                textAction.setText(R.string.lemon_empty_glass)
                lemonImage?.setImageResource(R.drawable.lemon_restart)
            }
        }
    }

    /**
     * === DO NOT ALTER THIS METHOD ===
     *
     * Long clicking the lemon image will show how many times the lemon has been squeezed.
     */
    private fun showSnackbar(): Boolean {
        if (lemonadeState != SQUEEZE) {
            return false
        }
        val squeezeText = getString(R.string.squeeze_count, squeezeCount)
        Snackbar.make(
            findViewById(R.id.constraint_Layout),
            squeezeText,
            Snackbar.LENGTH_SHORT
        ).show()
        return true
    }

    private fun styles() {
        // Color
        val activityColor = ContextCompat.getColor(this, R.color.yellow_dark)
        // Title
        val styledText = "<font color='#795548'>Lemonade App</font>."
        this.title = HtmlCompat.fromHtml(styledText, HtmlCompat.FROM_HTML_MODE_LEGACY)
        // Background ActionBar Color
        val actionBar = this.supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(activityColor))
        // StatusBar Color
        window.statusBarColor = activityColor
    }
}
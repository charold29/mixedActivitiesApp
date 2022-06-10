package upn.charold.mixed_activities_app.cooking_converter

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import upn.charold.mixed_activities_app.R
import upn.charold.mixed_activities_app.databinding.ActivityCookConvBinding

class CookConvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCookConvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCookConvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        styles()
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
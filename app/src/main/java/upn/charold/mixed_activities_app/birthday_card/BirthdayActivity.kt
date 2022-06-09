package upn.charold.mixed_activities_app.birthday_card

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import upn.charold.mixed_activities_app.R

class BirthdayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)

        styles()
    }

    private fun styles() {
        // Color
        val activityColor = ContextCompat.getColor(this, R.color.end_color)
        // Title
        this.title = "Birthday Card"
        // ActionBar
        val actionBar = this.supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(activityColor))
        // StatusBar Color
        window.statusBarColor = activityColor
    }
}
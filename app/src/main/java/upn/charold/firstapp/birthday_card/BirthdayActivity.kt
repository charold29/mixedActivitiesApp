package upn.charold.firstapp.birthday_card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import upn.charold.firstapp.R

class BirthdayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)
        this.title = "Birthday Card"
    }
}
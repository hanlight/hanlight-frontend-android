package kr.hanlight.signup.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hanlight.R

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SignUpAuthFragment.newInstance())
            .commit()
    }
}

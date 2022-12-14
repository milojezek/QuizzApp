package eu.milo4apps.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.button_start)
        val inputName: EditText = findViewById(R.id.input_name)

        btnStart.setOnClickListener {
            if (inputName.text.isEmpty()) {
                Toast.makeText(this, "Please, enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra(Constants.USER_NAME, inputName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}
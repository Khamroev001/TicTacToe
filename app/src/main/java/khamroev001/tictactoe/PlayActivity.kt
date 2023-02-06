package khamroev001.tictactoe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import khamroev001.tictactoe.R
import kotlinx.android.synthetic.main.play_layout.*

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_layout)

        playBtn.setOnClickListener {
            startActivity(Intent(this, PlayerNicks::class.java))
        }
    }
}
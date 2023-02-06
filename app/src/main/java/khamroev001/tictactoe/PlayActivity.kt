package khamroev001.tictactoe

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.play_layout.*

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_layout)

        playBtn.setOnClickListener {
            MediaPlayer.create(this, R.raw.play).start()
            startActivity(Intent(this, PlayerNicks::class.java))
        }
    }
}
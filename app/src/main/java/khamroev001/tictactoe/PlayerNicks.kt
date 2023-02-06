package khamroev001.tictactoe

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.players_nick.*

class PlayerNicks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.players_nick)

        next.setOnClickListener {
            MediaPlayer.create(this, R.raw.button).start()
            val intent = Intent(this, MainActivity::class.java)

            if (edit1.text.isNotEmpty()) {
                intent.putExtra ("playerX", edit1.text.toString())
            }
            else {
                intent.putExtra ("playerX", "Player X")
            }

            if (edit2.text.isNotEmpty()) {
                intent.putExtra ("player0", edit2.text.toString())
            }
            else {
                intent.putExtra ("player0", "Player O")
            }

            startActivity(intent)
        }
    }
}
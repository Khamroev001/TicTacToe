package khamroev001.tictactoe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import khamroev001.tictactoe.MainActivity
import khamroev001.tictactoe.R
import kotlinx.android.synthetic.main.players_nick.*

class PlayerNicks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.players_nick)

        next.setOnClickListener {
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
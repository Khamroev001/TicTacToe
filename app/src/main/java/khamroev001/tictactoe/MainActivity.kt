package khamroev001.tictactoe

import android.media.MediaPlayer
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var matrix = Array(3) { IntArray(3) { -1 } }
    var active = true
    private var xName = ""
    private var nameO = ""

    var mediaPlayer: MediaPlayer? = null
    private lateinit var animSet: Animation
    private lateinit var animSign_scale: Animation

    override fun onBackPressed() {
        super.onBackPressed()

        mediaPlayer?.stop()
    }

   override fun onPause(){
       super.onPause()
       mediaPlayer?.stop()
   }
    override fun onResume(){
        super.onResume()
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        xName = intent.getStringExtra("playerX").toString()
        nameO = intent.getStringExtra("player0").toString()

        animSet = AnimationUtils.loadAnimation(this, R.anim.anim_set)
        animSign_scale = AnimationUtils.loadAnimation(this, R.anim.anim_signscale)

        player1.text = xName
        player2.text = nameO

        active_player.text = xName

        img0.setOnClickListener(this)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)
        img6.setOnClickListener(this)
        img7.setOnClickListener(this)
        img8.setOnClickListener(this)
        restart.setOnClickListener {
            MediaPlayer.create(this, R.raw.button).start()
            restart()
        }

    }

    var k = 0
    override fun onClick(p0: View?) {
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.select)
        mediaPlayer.start()
        val img = findViewById<ImageButton>(p0!!.id)
        val t = img.tag.toString().toInt()
        val col: Int = t / 3
        val row: Int = t % 3
        if (matrix[col][row] == -1) {
            if (active) {
                img.setImageResource(R.drawable.x_sign)
                img.startAnimation(animSign_scale)
                active = false
                matrix[col][row] = 1
                isWinner(1)
                active_player.text = nameO
                k++
            } else {
                img.setImageResource(R.drawable.o_sign)
                img.startAnimation(animSign_scale)
                active = true
                matrix[col][row] = 0
                isWinner(0)
                active_player.text = xName
                k++
            }
        }

        if (k == 9) {
            winner.text = "Draw"
            finishGame()
        }
    }

    var count = 0
    private fun isWinner(a: Int) {
        // by horizontal side e.g: left to right
        horizontalCheck(a)
        count = 0

        // by vertical side e.g: top to bottom
        verticalCheck(a)
        count = 0

        // x 0 0
        // 0 x 0
        // 0 0 x
        fromLeftTopToRightBottomCheck(a)
        count = 0

        // 0 0 x
        // 0 x 0
        // x 0 0
        fromRightTopToBottomCheck(a)
        count = 0

    }

    private fun horizontalCheck(a: Int) {
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
            showWinnerName(a)
            count = 0
        }
    }

    private fun verticalCheck(a: Int) {
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
            showWinnerName(a)
            count = 0
        }
    }

    private fun fromLeftTopToRightBottomCheck(a: Int) {
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        showWinnerName(a)
    }

    private fun fromRightTopToBottomCheck(a: Int) {
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        showWinnerName(a)
    }

    private fun finishGame() {
        img0.isEnabled = false
        img1.isEnabled = false
        img2.isEnabled = false
        img3.isEnabled = false
        img4.isEnabled = false
        img5.isEnabled = false
        img6.isEnabled = false
        img7.isEnabled = false
        img8.isEnabled = false
        restart.visibility = View.VISIBLE
        restart.startAnimation(animSet)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.success )
        mediaPlayer.start()
        k = 0
    }

    private fun restart() {
        matrix = Array(3) { IntArray(3) { -1 } }
        active = true
        active_player.text = xName

        restart.visibility = View.INVISIBLE

        winner.text = ""

        img0.isEnabled = true
        img1.isEnabled = true
        img2.isEnabled = true
        img3.isEnabled = true
        img4.isEnabled = true
        img5.isEnabled = true
        img6.isEnabled = true
        img7.isEnabled = true
        img8.isEnabled = true

        img0.setImageDrawable(null)
        img1.setImageDrawable(null)
        img2.setImageDrawable(null)
        img3.setImageDrawable(null)
        img4.setImageDrawable(null)
        img5.setImageDrawable(null)
        img6.setImageDrawable(null)
        img7.setImageDrawable(null)
        img8.setImageDrawable(null)

        k = 0
    }

    private fun showWinnerName(a: Int) {
        var winnerName = ""
        winnerName = if (a == 0) nameO else xName

        if (count == 3) {
            winner.text = "Winner is $winnerName"
            if (a == 1) {
                player1_score.text = (player1_score.text.toString().toInt() + 1).toString()
            } else {
                player2_score.text = (player2_score.text.toString().toInt() + 1).toString()
            }
            finishGame()
            return
        }
    }
}
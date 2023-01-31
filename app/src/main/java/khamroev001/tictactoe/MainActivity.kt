package khamroev001.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var matrix = Array(3) { IntArray(3) { -1 } }
    var active = true
        var k=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        active_player.text = "Player X"

        a1.setOnClickListener(this)
        a2.setOnClickListener(this)
        a3.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        c1.setOnClickListener(this)
        c2.setOnClickListener(this)
        c3.setOnClickListener(this)
        restart.setOnClickListener {
            restart()
        }

    }

    override fun onClick(p0: View?) {
        val img = findViewById<ImageView>(p0!!.id)
        var t = img.tag.toString().toInt()-1
        var col: Int = t / 3
        var row: Int = t % 3


        if (matrix[col][row] == -1) {
            if (active) {
                img.setImageResource(R.drawable.x_sign)
                active = false
                matrix[col][row] = 1
                k++
                active_player.text = "Player 0"
                isWinner(1)
            } else {
                img.setImageResource(R.drawable.o_sign)
                active = true
                matrix[col][row] = 0
                k++
                active_player.text = "Player X"
                isWinner(0)
            }
            println("KKKKKKKKKKKKKKKKKKKKKKKKKKK")
            println(k)
            if (k==9){
                finishGame()
                winner.text="DRAW"
                k=0
            }
        }



    }

    fun isWinner(a: Int) {
        var count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
            if (count == 3) {
                if(a==1){
                    winner.text = "Winner is " + "X"
                }else{
                    winner.text = "Winner is " + "O"
                }
                finishGame()
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
            if (count == 3) {
                if(a==1){
                    winner.text = "Winner is " + "X"
                }else{
                    winner.text = "Winner is " + "O"
                }
                finishGame()
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            if(a==1){
                winner.text = "Winner is " + "X"
            }else{
                winner.text = "Winner is " + "O"
            }
            finishGame()
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            if(a==1){
                winner.text = "Winner is " + "X"
            }else{
                winner.text = "Winner is " + "O"
            }
            finishGame()
            return
        }
    }

    fun finishGame() {
        a1.isEnabled = false
        a2.isEnabled = false
        a3.isEnabled = false
        b1.isEnabled = false
        b2.isEnabled = false
        b3.isEnabled = false
        c1.isEnabled = false
        c2.isEnabled = false
        c3.isEnabled = false
        restart.visibility = View.VISIBLE
        k=0
    }

    fun restart() {
        matrix = Array(3) { IntArray(3) { -1 } }
        active = true
        active_player.text = "Player X"

        restart.visibility = View.INVISIBLE

        winner.text = ""

        a1.isEnabled = true
        a2.isEnabled = true
        a3.isEnabled = true
        b1.isEnabled = true
        b2.isEnabled = true
        b3.isEnabled = true
        c1.isEnabled = true
        c2.isEnabled = true
        c3.isEnabled = true

        a1.setImageDrawable(null)
        a2.setImageDrawable(null)
        a3.setImageDrawable(null)
        b1.setImageDrawable(null)
        b2.setImageDrawable(null)
        b3.setImageDrawable(null)
        c1.setImageDrawable(null)
        c2.setImageDrawable(null)
        c3.setImageDrawable(null)

        k=0
    }
}
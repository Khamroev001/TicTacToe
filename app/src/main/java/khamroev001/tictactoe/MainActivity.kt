package khamroev001.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var active:Boolean=true

    var matrix=Array(3){IntArray(3){-1} }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a1.setOnClickListener(this)
        a2.setOnClickListener(this)
        a3.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        c1.setOnClickListener(this)
        c2.setOnClickListener(this)
        c3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val img=findViewById<ImageButton>(v!!.id)
        val tag=img.tag.toString().toInt()-1
        var col:Int=tag/3
        var row:Int=tag%3
        if (active){
            img.setImageResource(R.drawable.x_sign)
            active=false
            matrix[col][row]=1
            isWinner(1)
        }else{
            img.setImageResource(R.drawable.o_sign)
            active=true
            matrix[col][row]=0
            isWinner(0)
        }
        img.isClickable=false


    }

    fun isWinner(a:Int) {
        var count = 0

        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
        }
        if (count == 3) {
            winner.text = " ${a.toString()} is winner"
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
        }
        if (count == 3) {
            winner.text = " ${a.toString()} is winner"
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    count++
                }
            }
        }
        if (count == 3) {
            winner.text = "${a.toString()} is winner "
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    count++
                }
            }
        }
        if (count == 3) {
            winner.text = "${a.toString()} is winner "
            return
        }
    }
}

package com.sg.generalpost10

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import coil.load
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var word1:TextView
    val ID_1 = 1
    val ID_2 = 2

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstPost()
    }

    private fun firstPost() {
        imageView.load(R.drawable.sad)
       // word1=locateWord("word1,"העולם", TOP,50, LEFT,100)
        word1=locateWord("word1","העולם", TOP,100, LEFT,200)
    }

    private fun locateWord(id:String, word: String, border1: String, margin1: Int, border2: String, margin2: Int): TextView {
      val textView=TextView(this)

        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        lp.apply {
            if (border2=="left") marginStart=8.toPx()
            if (border1=="top")topMargin=50.toPx()
            //  marginEnd=20.toDp()
            // bottomMargin=50.toDp()
        }

        textView.layoutParams = lp
        textView.id=ID_1
        textView.text=word

        mainLayout.addView(textView)






        val containSet = ConstraintSet()
        containSet.clone(mainLayout)

        containSet.connect(textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        containSet.connect(textView.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)

/*

        containSet.connect(ID_2, ConstraintSet.TOP, ID_1, ConstraintSet.BOTTOM)
        containSet.connect(ID_2, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
        containSet.connect(ID_2, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)*/
        containSet.applyTo(mainLayout)





        return textView
    }
}
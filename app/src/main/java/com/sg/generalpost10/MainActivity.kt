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
    lateinit var word2:TextView
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

       word1=locateWord(0,"בעולם אין בעיות בכלל", BOTTOM, RIGHT,0, 0,20,140)
     // word2=locateWord(1,"חוץ מהבעיות שאתה יוצר", BOTTOM, RIGHT,0, 0,20,100)





    }

    private fun locateWord(index:Int, word: String, border1: String,border2: String, mLeft: Int,mUp: Int,mRight:Int,mBottom:Int): TextView {
      val textView=TextView(this)

        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        val containSet = ConstraintSet()

        lp.apply {
            if ((border1== LEFT)|| (border2== LEFT)) marginStart=mLeft.toPx()
            if ((border1== TOP)|| (border2== TOP)) topMargin=mUp.toPx()
            if ((border1== RIGHT)|| (border2== RIGHT)) marginEnd=mRight.toPx()
            if ((border1== BOTTOM)|| (border2== BOTTOM)) bottomMargin=mBottom.toPx()
        }

        textView.layoutParams = lp
        textView.id=ID_1
        textView.text=word

        mainLayout.addView(textView)


        containSet.clone(mainLayout)


        if ((border1== LEFT)|| (border2== LEFT)){
            containSet.connect(textView.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
        }

        if ((border1== TOP)|| (border2== TOP)){
            containSet.connect(textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        }

        if ((border1== RIGHT)|| (border2== RIGHT)){
            containSet.connect(textView.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
        }

        if ((border1== BOTTOM)|| (border2== BOTTOM)){
            containSet.connect(textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        }


/*

        containSet.connect(ID_2, ConstraintSet.TOP, ID_1, ConstraintSet.BOTTOM)
        containSet.connect(ID_2, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
        containSet.connect(ID_2, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)*/



        //if (index==1) containSet.applyTo(mainLayout)

        containSet.applyTo(mainLayout)



        return textView
    }
}
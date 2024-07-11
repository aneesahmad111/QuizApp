package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.typeOf

class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener {

    private  var mCurrentPosition : Int = 1
    private  var mQuestionList : ArrayList<Question>? = null
    private  var mSelectedOptionPosition : Int = 0

    private  var mCorrectAnswer : Int = 0

    lateinit var progressbar : ProgressBar
    lateinit var Tvprogress : TextView
    lateinit var questionTv : TextView

    lateinit var option_one : TextView
    lateinit var option_two : TextView
    lateinit var option_three : TextView
    lateinit var option_four : TextView

    lateinit var submitBtn :    Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_question)

        progressbar = findViewById(R.id.progressbar)
        Tvprogress = findViewById(R.id.Tvprog)
        questionTv = findViewById(R.id.question_Tv)


        option_one = findViewById(R.id.option_one_TV)
        option_two = findViewById(R.id.option_two_TV)
        option_three = findViewById(R.id.option_three_TV)
        option_four = findViewById(R.id.option_four_TV)

        submitBtn = findViewById(R.id.SubBtn)

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        submitBtn.setOnClickListener(this)


        mQuestionList = Constants.getQuestion()

        extracted()
    }

    private fun extracted() {
        defaultOptionView()
        var question: Question = mQuestionList!![mCurrentPosition-1]
        progressbar.progress = mCurrentPosition
        Tvprogress.text = "$mCurrentPosition/${progressbar.max}"
        questionTv.text = question.question
        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text = question.optionFour

        if (mCurrentPosition == mQuestionList!!.size){
            submitBtn.text = "Finish"
        }
        else{
            submitBtn.text = "Next"
        }
    }


    private fun defaultOptionView(){

        var options  = ArrayList<TextView>()


        options.add(0,option_one)
        options.add(1,option_two)
        options.add(2,option_three)
        options.add(3,option_four)

        for (option in options){

            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.simpletextview)

        }

    }

    private fun selectedOptionView(tv:TextView,SelectedOptionNum : Int){
        defaultOptionView()
        mSelectedOptionPosition = SelectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this,R.drawable.customtextview)

    }

    override fun onClick(view: View?) {
       when(view?.id){
           R.id.option_one_TV ->{

               selectedOptionView(option_one,1)
           }
           R.id.option_two_TV ->{

               selectedOptionView(option_two,2)
           }
           R.id.option_three_TV ->{

               selectedOptionView(option_three,3)
           }
           R.id.option_four_TV ->{

               selectedOptionView(option_four,4)
           }
           R.id.SubBtn ->{

               if (mSelectedOptionPosition ==0){
                   mCurrentPosition++

                   when{
                       mCurrentPosition <= mQuestionList!!.size ->{
                           extracted()
                       }
                   }
               }else{
                   val question  = mQuestionList?.get(mCurrentPosition-1)
                   if (question!!.correctAnswer != mSelectedOptionPosition){
                       answerView(mSelectedOptionPosition, R.drawable.wronganswer)
                   }
                   else{
                       mCorrectAnswer++
                   }
                   answerView(question.correctAnswer,R.drawable.correctanwser)

                   if (mCurrentPosition == mQuestionList!!.size){
                       submitBtn.text = "Finish"
                       

                   }else{
                       submitBtn.text = "Go To The Next Question"

                   }
                   mSelectedOptionPosition = 0

               }
           }

       }
    }
    private fun answerView(answer: Int,drawableView: Int){
        when(answer){

            1->{
                option_one.background = ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                option_two.background = ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                option_three.background = ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                option_four.background = ContextCompat.getDrawable(this,drawableView)
            }
        }


    }
}
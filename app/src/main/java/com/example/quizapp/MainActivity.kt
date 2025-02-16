package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appCompatButton.setOnClickListener{

            if(binding.edName.text?.isEmpty() == true){
                Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }



    }
}
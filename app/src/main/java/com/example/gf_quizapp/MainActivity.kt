package com.example.gf_quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gf_quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoquizPet.setOnClickListener {
            var intent = Intent(this, gf_quiz_question::class.java)
            intent.putExtra("flag", "1")
            startActivity(intent)
        }

        binding.btnGoToRhQuiz.setOnClickListener {
            var intent = Intent(this, gf_quiz_question::class.java)
            intent.putExtra("flag", "3")
            startActivity(intent)
        }

        binding.btnQuizJuegos.setOnClickListener {
            var intent = Intent(this, gf_quiz_question::class.java)
            intent.putExtra("flag", "2")
            startActivity(intent)
        }

    }
}
package com.example.gf_quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.gf_quizapp.models.Constans
import com.example.gf_quizapp.models.Gf_question_data

class gf_quiz_question : AppCompatActivity() {
    private var userName: String? = null

    var questionsList: ArrayList<Gf_question_data> = Constans.getQuestions()
    private var currentQuestionIndex = 0;
    private var selectedAlternativeIndex = -1;
    private var isAnswerChecked = false;
    private var totalScore = 0;
    private val alternativesIds = arrayOf(R.id.optionOne, R.id.optionTwo, R.id.optionThree, R.id.optionFour)

    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var btnSubmit: Button? = null
    private var tvAlternatives: ArrayList<TextView>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val flagLayout:String = intent.getStringExtra("flag").toString()

        Log.e("Bandera", flagLayout)

        if(flagLayout == "1"){
            setTheme(R.style.ThemePet)
            questionsList = Constans.getQuestions()
        }else if(flagLayout == "2"){
            setTheme(R.style.ThemeGames)
            questionsList = Constans.getQuestionsGame()
        }else if(flagLayout == "3"){
            setTheme(R.style.ThemeRh)
            questionsList = Constans.getQuestionsRh()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gf_quiz_question)

        userName = "Grupo Formula"

        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvAlternatives = arrayListOf(
            findViewById(R.id.optionOne),
            findViewById(R.id.optionTwo),
            findViewById(R.id.optionThree),
            findViewById(R.id.optionFour),
        )

        updateQuestion()

        btnSubmit?.setOnClickListener {
            if (!isAnswerChecked) {
                val anyAnswerIsChecked = selectedAlternativeIndex != -1
                if (!anyAnswerIsChecked) {
                    Toast.makeText(this, "Por favor, selecciona una opción", Toast.LENGTH_SHORT).show()
                } else {
                    val currentQuestion = questionsList[currentQuestionIndex]
                    if (
                        selectedAlternativeIndex == currentQuestion.correctAnswerIndex
                    ) {
                        answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.correct_option_border_bg)
                        totalScore++
                    } else {
                        answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.wrong_option_border_bg)
                        answerView(tvAlternatives!![currentQuestion.correctAnswerIndex], R.drawable.correct_option_border_bg)
                    }

                    isAnswerChecked = true
                    btnSubmit?.text = if (currentQuestionIndex == questionsList.size - 1) "FINALIZAR" else "SIGUIENTE PREGUNTA"
                    selectedAlternativeIndex = -1
                }
            } else {
                if (currentQuestionIndex < questionsList.size - 1) {
                    currentQuestionIndex++
                    updateQuestion()
                } else {
                    /*val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constans.USER_NAME, userName)
                    intent.putExtra(Constans.TOTAL_QUESTIONS, questionsList.size)
                    intent.putExtra(Constans.SCORE, totalScore)
                    startActivity(intent)
                    finish()*/
                }

                isAnswerChecked = false
            }
        }

        tvAlternatives?.let {
            for (optionIndex in it.indices) {
                it[optionIndex].let {
                    it.setOnClickListener{
                        if (!isAnswerChecked) {
                            selectedAlternativeView(it as TextView, optionIndex)
                        }
                    }
                }
            }
        }
    }

    private fun updateQuestion() {
        defaultAlternativesView()

        // Render Question Text
        tvQuestion?.text = questionsList[currentQuestionIndex].questionText
        // Render Question Image
        ivImage?.setImageResource(questionsList[currentQuestionIndex].image)
        // progressBar
        progressBar?.progress = currentQuestionIndex + 1
        // Text of progress bar
        tvProgress?.text = "${currentQuestionIndex + 1}/${questionsList.size}"

        for (alternativeIndex in questionsList[currentQuestionIndex].alternatives.indices) {
            tvAlternatives!![alternativeIndex].text = questionsList[currentQuestionIndex].alternatives[alternativeIndex]
        }

        btnSubmit?.text = if (currentQuestionIndex == questionsList.size - 1) "FINALIZAR" else "SIGUIENTE PREGUNTA"
    }

    private fun defaultAlternativesView() {
        for (alternativeTv in tvAlternatives!!) {
            alternativeTv.typeface = Typeface.DEFAULT
            alternativeTv.setTextColor(Color.parseColor("#7A8089"))
            alternativeTv.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedAlternativeView(option: TextView, index: Int) {
        defaultAlternativesView()
        selectedAlternativeIndex = index

        option.setTextColor(
            Color.parseColor("#363A43")
        )
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(view: TextView, drawableId: Int) {
        view.background = ContextCompat.getDrawable(
            this,
            drawableId
        )
        tvAlternatives!![selectedAlternativeIndex].setTextColor(
            Color.parseColor("#FFFFFF")
        )
    }
}
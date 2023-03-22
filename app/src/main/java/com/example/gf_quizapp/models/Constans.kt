package com.example.gf_quizapp.models

import com.example.gf_quizapp.R

object Constans {
    fun getQuestions(): ArrayList<Gf_question_data>{
        val questionsList = ArrayList<Gf_question_data>()
        val questionOne = Gf_question_data(
            0,
            "¿Que raza es considerada protectora de niños?",
            R.drawable.dog_app,
            arrayListOf("Chihuahua", "Pitbull",
                "Sanuzer", "Labrador"),
            1
        )

        questionsList.add(questionOne)
        val questionTwo = Gf_question_data(
            0,
            "¿A cuanto años humano equivale 1 año perruno?",
            R.drawable.dog_app,
            arrayListOf("2", "5",
                "6", "7"),
            2
        )

        questionsList.add(questionTwo)
        val questionThree = Gf_question_data(
            0,
            "¿Cuantas veces debemos pasear a nuestros perrunos?",
            R.drawable.dog_app,
            arrayListOf("2", "1",
                "Diario", "Cada Mes"),
            2
        )

        questionsList.add(questionThree)

        val questionFour = Gf_question_data(
            0,
            "¿Cual es el enemigo de los perros?",
            R.drawable.dog_app,
            arrayListOf("Rata", "Pitbull",
                "Loeon", "Gato"),
            3
        )

        questionsList.add(questionFour)

        return questionsList
    }
    /*Get Questions Games*/
    fun getQuestionsGame(): ArrayList<Gf_question_data>{
        val questionsList = ArrayList<Gf_question_data>()
        val questionOne = Gf_question_data(
            0,
            "¿Que consola fue lanzada en el 2001?",
            R.drawable.game_app,
            arrayListOf("Play station", "Xbox",
                "Psp", "Wii"),
            1
        )

        questionsList.add(questionOne)
        return questionsList
    }

    fun getQuestionsRh(): ArrayList<Gf_question_data>{
        val questionsList = ArrayList<Gf_question_data>()
        val questionOne = Gf_question_data(
            0,
            "¿Cual es el primer criterio a evaluar de un candidato?",
            R.drawable.rh_app,
            arrayListOf("Actitud", "CV",
                "Estudios", "Todas las anteriores"),
            1
        )

        questionsList.add(questionOne)
        return questionsList
    }
}
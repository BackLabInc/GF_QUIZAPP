package com.example.gf_quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gf_quizapp.databinding.ActivityGfQuizDynamicBinding
import com.example.gf_quizapp.models.gf_question

class gf_quiz_dynamic : AppCompatActivity() {
    lateinit var mBinding: ActivityGfQuizDynamicBinding
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : gf_recycler_adapter = gf_recycler_adapter()
    override fun onCreate(savedInstanceState: Bundle?) {

        val flagLayout:String = intent.getStringExtra("flag").toString()

        Log.e("Bandera", flagLayout)

        if(flagLayout == "1"){
            setTheme(R.style.ThemePet)
        }else if(flagLayout == "2"){
            setTheme(R.style.ThemeGames)
        }else if(flagLayout == "3"){
            setTheme(R.style.ThemeRh)
        }
        super.onCreate(savedInstanceState)
        mBinding = ActivityGfQuizDynamicBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setUpRecyclerView()

    }
    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.rvSuperheroList) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getSuperheros(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getSuperheros(): MutableList<gf_question>{
        var superheros:MutableList<gf_question> = ArrayList()
        superheros.add(gf_question("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(gf_question("Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(gf_question("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(gf_question("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(gf_question("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(gf_question("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(gf_question("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(gf_question("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))
        return superheros
    }

}
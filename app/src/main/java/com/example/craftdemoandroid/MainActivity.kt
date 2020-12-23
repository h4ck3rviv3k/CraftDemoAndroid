package com.example.craftdemoandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.craftdemoandroid.adapter.ScoreAnalysisAdapter
import com.example.craftdemoandroid.model.ScoreAnalysisData
import com.example.craftdemoandroid.model.ScoreAnalysisReport
import com.example.craftlibrary.progressbar.CircularProgressIndicator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.io.Reader

class MainActivity : AppCompatActivity() {
    private var scoreAnalysisAdapter: ScoreAnalysisAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Score Progress
        val circularProgressIndicator =
            findViewById<CircularProgressIndicator>(R.id.circular_progress)
        circularProgressIndicator.setProgress(890.toDouble(), 900.toDouble())

        //Score Analysis
        val scoreAnalysisData = getScoreAnalysisData().scoreAnalysisData
        val recyclerView = findViewById<RecyclerView>(R.id.rv_score_analysis)
        recyclerView.layoutManager = LinearLayoutManager(this)
        if (recyclerView.adapter == null) {
            scoreAnalysisAdapter = ScoreAnalysisAdapter(scoreAnalysisData)
            recyclerView.adapter = scoreAnalysisAdapter
        } else {
            scoreAnalysisAdapter?.setUpdatedData(scoreAnalysisData)
            scoreAnalysisAdapter?.notifyDataSetChanged()
        }

    }

    private fun getScoreAnalysisData(): ScoreAnalysisReport {
        val scoreAnalysisData: Reader
        try {
            scoreAnalysisData = InputStreamReader(this.assets.open("score-analysis.json"))
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

        val jsonType = object : TypeToken<ScoreAnalysisReport>() {}.type
        return Gson().fromJson<ScoreAnalysisReport>(scoreAnalysisData, jsonType)

    }
}
package com.example.craftdemoandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.craftdemoandroid.adapter.ScoreAnalysisAdapter
import com.example.craftdemoandroid.model.ScoreAnalysisData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.io.Reader

class MainActivity : AppCompatActivity() {
    private var scoreAnalysisAdapter: ScoreAnalysisAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_score)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_score_analysis)
        recyclerView.layoutManager = LinearLayoutManager(this)
        if (recyclerView.adapter == null) {
            scoreAnalysisAdapter = ScoreAnalysisAdapter(getScoreAnalysisData())
            recyclerView.adapter = scoreAnalysisAdapter
        } else {
            scoreAnalysisAdapter?.notifyDataSetChanged()
        }

    }

    private fun getScoreAnalysisData(): List<ScoreAnalysisData> {
        val scoreAnalysisData: Reader
        try {
            scoreAnalysisData = InputStreamReader(this.assets.open("score-analysis.json"))
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

        val jsonType = object : TypeToken<List<ScoreAnalysisData>>() {}.type
        return Gson().fromJson<List<ScoreAnalysisData>>(scoreAnalysisData, jsonType)

    }
}
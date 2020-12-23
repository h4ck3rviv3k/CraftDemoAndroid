package com.example.craftdemoandroid.model

import java.io.Serializable

data class ScoreAnalysisReport(val scoreAnalysisData: List<ScoreAnalysisData>) : Serializable

data class ScoreAnalysisData(
    val scoreInPercentage: String,
    val minScore: String,
    val maxScore: String,
    val score: String,
    val showIndicator: Boolean
) : Serializable
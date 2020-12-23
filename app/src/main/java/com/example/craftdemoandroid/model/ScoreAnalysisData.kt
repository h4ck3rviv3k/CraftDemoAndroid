package com.example.craftdemoandroid.model

import java.io.Serializable

data class ScoreAnalysisData(
    val score: String,
    val minScore: String,
    val maxScore: String,
    val avgScoreInRange: String,
    val showIndicator: Boolean
) : Serializable
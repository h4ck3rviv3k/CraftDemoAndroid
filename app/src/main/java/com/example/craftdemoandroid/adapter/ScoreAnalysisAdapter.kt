package com.example.craftdemoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.craftdemoandroid.R
import com.example.craftdemoandroid.model.ScoreAnalysisData

class ScoreAnalysisAdapter(var scoreAnalysisData: List<ScoreAnalysisData>) :
    RecyclerView.Adapter<ScoreAnalysisAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_score, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val scoreData = scoreAnalysisData[position]
        holder.scoreInProgress.text = scoreData.scoreInPercentage
        holder.tvRange.text =
            String.format(context.getString(R.string.range), scoreData.minScore, scoreData.maxScore)

        holder.tvIndicator.visibility = View.GONE
        holder.clIndicator.visibility = View.GONE
        if (scoreData.showIndicator) {
            holder.tvIndicator.visibility = View.VISIBLE
            holder.clIndicator.visibility = View.VISIBLE
            holder.tvIndicator.text = scoreData.score
        }

    }

    override fun getItemCount() = scoreAnalysisData.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val scoreInProgress: TextView = itemView.findViewById(R.id.tv_score_in_percentage)
        val tvRange: TextView = itemView.findViewById(R.id.tv_range)
        val tvIndicator: TextView = itemView.findViewById(R.id.tv_indicator_value)
        val clIndicator: ViewGroup = itemView.findViewById(R.id.cl_indicator)
    }

    fun setUpdatedData(scoreAnalysisData: List<ScoreAnalysisData>) {
        this.scoreAnalysisData = scoreAnalysisData
    }
}
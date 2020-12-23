package com.example.craftdemoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.craftdemoandroid.R
import com.example.craftdemoandroid.model.ScoreAnalysisData

class ScoreAnalysisAdapter(val scoreAnalysisData: List<ScoreAnalysisData>) : RecyclerView.Adapter<ScoreAnalysisAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_score, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context


    }

    override fun getItemCount() = 1
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
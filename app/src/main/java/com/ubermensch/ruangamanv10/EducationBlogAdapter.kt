package com.ubermensch.ruangamanv10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EducationBlogAdapter(
    private val educationList: List<EducationItem>,
    private val onItemClick: (EducationItem) -> Unit
) : RecyclerView.Adapter<EducationBlogAdapter.EducationViewHolder>() {

    class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvItemTitle)
        val tvShortDesc: TextView = itemView.findViewById(R.id.tvItemShortDesc)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvItemAuthor)
        val tvDate: TextView = itemView.findViewById(R.id.tvItemDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_education_detail, parent, false)
        return EducationViewHolder(view)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val item = educationList[position]

        holder.tvTitle.text = item.title
        holder.tvShortDesc.text = item.shortDescription
        holder.tvAuthor.text = item.author
        holder.tvDate.text = item.date

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = educationList.size
}


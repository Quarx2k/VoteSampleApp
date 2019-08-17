package com.quarx2k.vote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quarx2k.vote.holders.QuestionHolder
import com.quarx2k.vote.model.Question

class QuestionsAdapter(private val questions : List<Question>) : RecyclerView.Adapter<QuestionHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_holder, parent, false)
        return QuestionHolder(view)
    }

    override fun getItemCount(): Int = questions.size
    override fun onBindViewHolder(holder: QuestionHolder, position: Int) = holder.onBind(questions[position])

}
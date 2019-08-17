package com.quarx2k.vote.holders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quarx2k.vote.AnswersAdapter
import com.quarx2k.vote.model.Question
import kotlinx.android.synthetic.main.question_holder.view.*

open class QuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(question: Question) {
        itemView.title.text = "%s %s".format("Вопрос:", question.id)
        itemView.answer_recycler.layoutManager = LinearLayoutManager(itemView.context)
        itemView.answer_recycler.adapter = AnswersAdapter(question.answers)
    }
}
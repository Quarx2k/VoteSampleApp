package com.quarx2k.vote.holders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quarx2k.vote.AnswersAdapter
import com.quarx2k.vote.model.Answer
import com.quarx2k.vote.model.Question
import kotlinx.android.synthetic.main.question_holder.view.*

abstract class AnswerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(adapter: AnswersAdapter, payloads: MutableList<Any>, answers: List<Answer>, answer: Answer)
}
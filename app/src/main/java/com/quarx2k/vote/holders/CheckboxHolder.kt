package com.quarx2k.vote.holders

import android.view.View
import com.quarx2k.vote.AnswersAdapter
import com.quarx2k.vote.model.Answer
import kotlinx.android.synthetic.main.answer_checkbox_holder.view.*

class CheckboxHolder(itemView: View) : AnswerHolder(itemView) {
    override fun onBind(adapter: AnswersAdapter, payloads: MutableList<Any>, answers: List<Answer>, answer: Answer) {
        itemView.checkbox.text = answer.title
        itemView.checkbox.isChecked = answer.value != null
        itemView.checkbox.setOnCheckedChangeListener { _, b ->
            if (b) {
                answer.value = "We Selected!"
            } else {
                answer.value = null
            }
        }
    }
}
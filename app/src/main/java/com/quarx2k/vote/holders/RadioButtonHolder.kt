package com.quarx2k.vote.holders

import android.view.View
import com.quarx2k.vote.AnswersAdapter
import com.quarx2k.vote.model.Answer
import kotlinx.android.synthetic.main.answer_radio_holder.view.*
import java.util.*

class RadioButtonHolder(itemView: View) : AnswerHolder(itemView) {
    override fun onBind(adapter: AnswersAdapter, payloads: MutableList<Any>, answers: List<Answer>, answer: Answer) {
        itemView.radioButton.text = answer.title
        itemView.radioButton.isChecked = answer.value != null
        if (payloads.isEmpty()) {
            itemView.radioButton.setOnCheckedChangeListener { _, b ->
                if (b) {
                    answer.value = "We Love Radio Button"
                    answers.filter { it != answer }.onEach { it.value = null }
                    println("Old position: %d, New position: %d".format(oldPosition, adapterPosition))
                    adapter.notifyItemRangeChanged(0, answers.size, Object())
                }
            }
        }
    }
}
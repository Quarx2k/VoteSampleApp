package com.quarx2k.vote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quarx2k.vote.holders.AnswerHolder
import com.quarx2k.vote.holders.CheckboxHolder
import com.quarx2k.vote.holders.RadioButtonHolder
import com.quarx2k.vote.holders.TextHolder
import com.quarx2k.vote.model.Answer
import com.quarx2k.vote.model.AnswerType
import org.w3c.dom.Text

class AnswersAdapter(private val answers : List<Answer>) : RecyclerView.Adapter<AnswerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerHolder {
        return when (AnswerType.values()[viewType]) {
            AnswerType.RadioButton -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.answer_radio_holder, parent, false)
                RadioButtonHolder(view)
            }
            AnswerType.Checkbox -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.answer_checkbox_holder, parent, false)
                CheckboxHolder(view)
            }
            AnswerType.EditText -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.answer_text_holder, parent, false)
                TextHolder(view)
            }
        }
    }
    override fun onBindViewHolder(holder: AnswerHolder, position: Int) = onBindViewHolder(holder, position, emptyList<Any>().toMutableList())
    override fun getItemCount(): Int = answers.size
    override fun onBindViewHolder(holder: AnswerHolder, position: Int, payloads: MutableList<Any>) = holder.onBind(this, payloads, answers, answers[position])
    override fun getItemViewType(position: Int): Int = answers[position].type.ordinal
}
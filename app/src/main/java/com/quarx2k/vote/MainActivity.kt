package com.quarx2k.vote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.quarx2k.vote.model.Answer
import com.quarx2k.vote.model.AnswerType
import com.quarx2k.vote.model.Question
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
    }

    private fun setAdapter() {
        vote_recycler.layoutManager = LinearLayoutManager(this)
        vote_recycler.adapter = QuestionsAdapter(generateMockData())
    }

    private fun generateMockData() : List<Question> {
        val questions = mutableListOf<Question>()
        for (i in 1..100) {
            val question = Question(i, getRandomBoolean())
            val answerType = getRandomAnswerType()
            for (j in 1..13) {
                val answer = Answer(j, answerType, System.nanoTime().toString(), null)
                question.answers.add(answer)
            }
            /*  So sad, we not need this  =(
            if (question.needEditField) {
                question.answers.add(Answer(System.nanoTime().toInt(), AnswerType.EditText, "", null))
            }*/
            questions.add(question)
        }
        return questions
    }

    private fun getRandomBoolean(): Boolean {
        return Math.random() < 0.55
    }

    private fun getRandomAnswerType() : AnswerType {
        val arr = arrayOf(AnswerType.Checkbox, AnswerType.RadioButton)
        val randomNumber = Random().nextInt(arr.size)
        return arr[randomNumber]
    }
}

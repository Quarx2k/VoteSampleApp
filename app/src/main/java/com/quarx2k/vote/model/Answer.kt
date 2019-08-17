package com.quarx2k.vote.model

class Answer(val id: Int, val type: AnswerType, val title: String, var value: String?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Answer

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}


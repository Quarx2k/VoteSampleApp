package com.quarx2k.vote.model

data class Question(val id: Int, val needEditField: Boolean) {
    var answers: MutableList<Answer> = mutableListOf()
}
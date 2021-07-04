package com.busra.anagramgame

import java.util.*

object Anagram {
    private val RANDOM = Random()
    private val WORDS = arrayOf(
        "ACCOUNT", "ADDITION",
        "AGREEMENT", "ANGRY", "ANIMAL", "BEHAVIOUR", "BETWEEN", "BLACK", "CHEMICAL", "FOOLISH",
        "FREQUENT", "GOVERNMENT", "GRAIN", "GRASS", "HOSPITAL", "PAYMENT", "POLITICAL",
        "PROCESS", "SHAME", "SMASH", "SMOOTH", "STATEMENT", "SUBSTANCE", "TEACHING", "TENDENCY",
        "TOMORROW", "TOUCH", "UMBRELLA", "WEATHER", "YESTERDAY"
    )

    fun randomWord(): String {
        return WORDS[RANDOM.nextInt(WORDS.size)]
    }

    fun shuffleWord(word: String?): String? {
        if (word != null && "" != word) {
            val a = word.toCharArray()
            for (i in a.indices) {
                val j = RANDOM.nextInt(a.size)
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
            }
            return String(a)
        }
        return word
    }
}
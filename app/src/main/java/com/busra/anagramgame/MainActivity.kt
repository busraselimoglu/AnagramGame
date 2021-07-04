package com.busra.anagramgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.busra.anagramgame.Anagram.randomWord
import com.busra.anagramgame.Anagram.shuffleWord

class MainActivity : AppCompatActivity() {

    private var wordTv: TextView? = null
    private var wordEnteredTv: EditText? = null
    private var validate: Button? = null
    private var newGame: Button? = null
    private var wordToFind: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wordTv = findViewById<View>(R.id.wordTv) as TextView
        wordEnteredTv = findViewById<View>(R.id.wordEnteredTv) as EditText
        validate = findViewById<View>(R.id.validate) as Button
        validate!!.setOnClickListener {
            validate()
        }
        newGame = findViewById<View>(R.id.newGame) as Button
        newGame!!.setOnClickListener {
            if (it === validate) {
                validate()
            } else if (it === newGame) {
                newGame()
            }
        }
        newGame()
    }

    private fun validate() {
        val w = wordEnteredTv!!.text.toString()
        if (wordToFind == w) {
            Toast.makeText(this, "Congratulations ! You found the word $wordToFind", Toast.LENGTH_SHORT).show()
            newGame()
        } else {
            Toast.makeText(this, "Retry !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun newGame() {
        wordToFind = randomWord()
        val wordShuffled = shuffleWord(wordToFind)
        wordTv!!.text = wordShuffled
        wordEnteredTv!!.setText("")
    }
}
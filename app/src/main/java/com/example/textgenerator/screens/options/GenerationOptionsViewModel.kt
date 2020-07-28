package com.example.textgenerator.screens.options

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GenerationOptionsViewModel : ViewModel() {
    private val _navigateToResultParagraphFragment = MutableLiveData<Boolean>()
    val navigateToResultParagraphFragment : LiveData<Boolean>
        get() = _navigateToResultParagraphFragment

    fun clickOnConfirmButton() {
        _navigateToResultParagraphFragment.value = true
    }

    fun doneNavigatingToResultParagraphFragment() {
        _navigateToResultParagraphFragment.value = false
    }

    fun generateParagraph(numberOfParagraphs : String) : String {
        val beginningOfTheParagraph = "Hello, this is just the beginning of this paragraph."
        val sentence = "This is a sentence of this paragraph."
        val endOfParagraph = "Bye, this is the end of this paragraph.\n\n"

        var result = ""

        for(i in 1..numberOfParagraphs.toInt()) {
            var paragraph = beginningOfTheParagraph +
                    sentence.repeat(Random.nextInt(10)) +
                    endOfParagraph

            result += (paragraph)
        }

        return result
    }
}
package com.example.textgenerator.screens.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {
    private val _navigateToGenerationOptionsFragment = MutableLiveData<Boolean>()
    val navigateToGenerationOptionsFragment : LiveData<Boolean>
        get() = _navigateToGenerationOptionsFragment

    private val _navigateToAboutPage = MutableLiveData<Boolean>()
    val navigateToAboutPage : LiveData<Boolean>
        get() = _navigateToAboutPage

    fun clickOnGenerateTextButton() {
        _navigateToGenerationOptionsFragment.value = true
    }

    fun clickOnAboutButton() {
        _navigateToAboutPage.value = true
    }

    fun doneNavigatingToGenerateOptionsFragment() {
        _navigateToGenerationOptionsFragment.value = false
    }

    fun doneNavigatingToAboutFragment() {
        _navigateToAboutPage.value = false
    }
}
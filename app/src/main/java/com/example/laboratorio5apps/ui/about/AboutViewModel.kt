package com.example.laboratorio5apps.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = "Diego Alvarez 19498"
    }
    val name: LiveData<String> = _name
    private val _course = MutableLiveData<String>().apply {
        value = "Apps - Laboratorio 7"
    }
    val course: LiveData<String> = _course

}
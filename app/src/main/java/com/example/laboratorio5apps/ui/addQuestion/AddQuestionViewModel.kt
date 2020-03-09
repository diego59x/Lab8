package com.example.laboratorio5apps.ui.addQuestion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio5apps.models.DataBase
import com.example.laboratorio5apps.models.entities.Question
import com.example.laboratorio5apps.repositories.QuestionRepository
import kotlinx.coroutines.launch

class AddQuestionViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val questionRepository: QuestionRepository

    init {
        // Gets reference to QuestionDAO from RoomDatabase to construct
        // the correct QuestionRepository.
        val questionDAO = DataBase.getInstance(application, viewModelScope).questionDAO()
        questionRepository = QuestionRepository(questionDAO)
    }

    fun insert(question: Question) = viewModelScope.launch {
        questionRepository.insert(question)
    }

    override fun onCleared() {
        super.onCleared()
        questionRepository.cancelJob()
    }
}
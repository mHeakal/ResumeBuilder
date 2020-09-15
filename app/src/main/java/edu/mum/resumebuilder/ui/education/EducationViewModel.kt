package edu.mum.resumebuilder.ui.academic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EducationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is education Fragment"
    }
    val text: LiveData<String> = _text
}
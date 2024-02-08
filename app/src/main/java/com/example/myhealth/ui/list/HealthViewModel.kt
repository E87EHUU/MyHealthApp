package com.example.myhealth.ui.list

import androidx.lifecycle.ViewModel
import com.example.myhealth.data.HealthRepository
import com.example.myhealth.data.model.Indication

class HealthViewModel(private val repository: HealthRepository) : ViewModel() {

    fun getLivData() = repository.liveData

    fun setIndication(indication: Indication) {
        repository.setIndications(indication)
    }

}
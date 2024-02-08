package com.example.myhealth.di

import com.example.myhealth.data.HealthRepository
import com.example.myhealth.ui.list.HealthViewModel
import com.example.myhealth.ui.list.IndicationAdapter
import com.example.myhealth.ui.list.ListAdapter
import com.google.firebase.Firebase
import com.google.firebase.database.database
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { IndicationAdapter() }
    factory { ListAdapter(get()) }
    single { Firebase.database.getReference("Healths") }
    single { HealthRepository(get()) }
    viewModel { HealthViewModel(get()) }
}
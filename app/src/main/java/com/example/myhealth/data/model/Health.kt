package com.example.myhealth.data.model

data class Health(
    val date: String? = "",
    val indications: List<Indication>? = emptyList()
)
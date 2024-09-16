package com.bignerdranch.android.application_19

import java.text.DateFormat
import java.time.LocalDate
import java.util.UUID

data class Crime (
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var isSolved: Boolean,
    val date: String
)

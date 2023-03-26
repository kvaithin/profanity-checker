package com.kvaithin.profanity

data class ProfanityModel(
    val language: String,
    val text: String,
    val canonicalForm1: String,
    val canonicalForm2: String,
    val canonicalForm3: String,
    val category1: String,
    val category2: String,
    val category3: String,
    val severityRating: String,
    val severityDescription: String,
)

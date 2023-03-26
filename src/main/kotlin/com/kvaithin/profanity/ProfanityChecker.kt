package com.kvaithin.profanity

import java.io.File

object ProfanityChecker {

    private val listMap = mutableMapOf<String, List<ProfanityModel>>()

    private fun getProfanityList(language: String): List<ProfanityModel> {
        return listMap.getOrPut(language) { initializeProfanityList(language) }
    }

    private fun initializeProfanityList(language: String): List<ProfanityModel> {
        val csvFile = File("profanity_list/profanity_${language}.csv")
        val profanityList = mutableListOf<ProfanityModel>()
        csvFile.bufferedReader().useLines { lines ->
            lines.drop(1).forEach { line ->
                val values = line.split(",").map { it.trim() }
                val profanity = ProfanityModel(
                    language,
                    values[0],
                    values[1],
                    values[2],
                    values[3],
                    values[4],
                    values[5],
                    values[6],
                    values[7],
                    values[8],
                )
                profanityList.add(profanity)
            }
        }
        return profanityList
    }

    fun searchProfanityListForText(text: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.text == text }
    }

    fun searchProfanityListForCanonicalForm1(canonicalForm1: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.canonicalForm1 == canonicalForm1 }
    }

    fun searchProfanityListForCanonicalForm2(canonicalForm2: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.canonicalForm2 == canonicalForm2 }
    }

    fun searchProfanityListForCanonicalForm3(canonicalForm3: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.canonicalForm3 == canonicalForm3 }
    }

    fun searchProfanityListForCategory1(category1: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.category1 == category1 }
    }

    fun searchProfanityListForCategory2(category2: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.category2 == category2 }
    }

    fun searchProfanityListForCategory3(category3: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.category3 == category3 }
    }

    fun searchProfanityListForAtLeastSeverityRatingOf(severityRating: Double, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.severityRating.toDoubleOrNull()!! >= severityRating }
    }

    fun searchProfanityListForSeverityDescription(severityDescription: String, language: String = "en"): List<ProfanityModel> {
        return getProfanityList(language).filter { it.severityDescription == severityDescription }
    }

    fun textHasProfanity(text: String, language: String = "en"): Boolean {
        return getProfanityList(language).any { profanity ->
            text.contains(profanity.text, ignoreCase = true)
        }
    }
}

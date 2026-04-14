package com.ubermensch.ruangamanv10

import java.io.Serializable

data class EducationItem(
    val title: String,
    val shortDescription: String,
    val content: String,
    val author: String,
    val date: String
) : Serializable
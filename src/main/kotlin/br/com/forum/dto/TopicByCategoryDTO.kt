package br.com.forum.dto

import java.io.Serializable

data class TopicByCategoryDTO(
    val category: String,
    val quantity: Long
): Serializable

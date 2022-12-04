package br.com.forum.dto

import java.io.Serializable
import java.time.LocalDateTime

data class ErrorViewDTO(
    val timeStamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
): Serializable

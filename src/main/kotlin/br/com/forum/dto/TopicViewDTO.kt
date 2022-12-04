package br.com.forum.dto

import br.com.forum.enums.TopicStatusEnum
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

data class TopicViewDTO(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatusEnum,
    val creationDate: LocalDateTime,
    val changeDate: LocalDate?
): Serializable

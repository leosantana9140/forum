package br.com.forum.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class ReplyFormDTO(
    @field: NotNull
    @field: Size(min = 5, max = 100)
    val message: String,

    @field: NotNull
    val topicId: Long,

    @field: NotNull
    val userId: Long
)

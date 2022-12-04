package br.com.forum.dto

import java.io.Serializable
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateTopicFormDTO(
    @field: NotNull
    val id: Long,

    @field: NotEmpty
    @field: Size(min = 5, max = 100)
    val title: String,

    @field: NotEmpty
    @field: Size(min = 5, max = 100)
    val message: String
): Serializable

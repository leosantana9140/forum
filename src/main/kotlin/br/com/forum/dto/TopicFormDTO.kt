package br.com.forum.dto

import java.io.Serializable
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicFormDTO(
    @field: NotEmpty(message = "O título não pode estar em branco")
    @field: Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres")
    val title: String,

    @field: NotEmpty(message = "A mensagem não pode estar em branco")
    @field: Size(min = 5, max = 100, message = "A mensagem deve ter entre 5 e 100 caracteres")
    val message: String,

    @field: NotNull
    val courseId: Long,

    @field: NotNull
    val userId: Long
): Serializable

package br.com.alura.forum.model

import br.com.alura.forum.enum.StatusEnum
import java.time.LocalDateTime

data class Topico(
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val usuario: Usuario,
    val status: StatusEnum = StatusEnum.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)

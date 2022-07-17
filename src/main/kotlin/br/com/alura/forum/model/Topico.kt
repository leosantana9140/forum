package br.com.alura.forum.model

import br.com.alura.forum.enum.StatusTopicoEnum
import java.time.LocalDateTime

data class Topico(
    var id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val usuario: Usuario,
    val status: StatusTopicoEnum = StatusTopicoEnum.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)

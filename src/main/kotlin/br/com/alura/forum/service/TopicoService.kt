package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico1 = Topico(
            id = 1,
            titulo = "Dúvida com Kotlin",
            mensagem = "Estou com problema para configurar as variáveis de ambiente do Kotlin",
            curso = Curso(
                id = 1, nome = "Kotlin", categoria = "Programação"
            ),
            usuario = Usuario(
                id = 1, nome = "Leonardo", email = "leonardo@gmail.com"
            )
        )

        val topico2 = Topico(
            id = 2, titulo = "Dúvida com PHP", mensagem = "Estou com problema para chamar uma função", curso = Curso(
                id = 2, nome = "PHP", categoria = "Programação"
            ), usuario = Usuario(
                id = 2, nome = "Marcelo", email = "marcelo@gmail.com"
            )
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Dúvida com React",
            mensagem = "Estou com problema no alinhamento de um botão",
            curso = Curso(
                id = 3, nome = "React", categoria = "Programação"
            ),
            usuario = Usuario(
                id = 3, nome = "Hiago", email = "hiago@gmail.com"
            )
        )

        topicos = listOf(topico1, topico2, topico3);
    }

    fun listaTopicos(): List<Topico> {
        return topicos;
    }

    fun buscaTopicoPorID(id: Long): Topico {
        return topicos.stream().filter({ topico -> topico.id == id }).findFirst().get()
    }

}

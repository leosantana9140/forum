package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(var cursos: List<Curso>) {

    init {
        val curso = Curso(
            id = 1, nome = "Spring", categoria = "Programação"
        )

        cursos = listOf(curso)
    }

    fun buscaCursoPorID(id: Long): Curso {
        return cursos.stream().filter { curso -> curso.id == id }.findFirst().get()
    }

}

package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1, nome = "Leonardo", email = "leonardo@gmail.com"
        )

        usuarios = listOf(usuario)
    }

    fun buscaUsuarioPorID(id: Long): Usuario {
        return usuarios.stream().filter { usuario -> usuario.id == id }.findFirst().get()
    }

}

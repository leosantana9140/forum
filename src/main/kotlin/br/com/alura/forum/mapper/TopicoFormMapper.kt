package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoFormDTO
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(private val cursoService: CursoService, private val usuarioService: UsuarioService): Mapper<TopicoFormDTO, Topico> {

    override fun map(topicoFormDTO: TopicoFormDTO): Topico {
        return Topico(
            titulo = topicoFormDTO.titulo,
            mensagem = topicoFormDTO.mensagem,
            curso = cursoService.buscaCursoPorID(topicoFormDTO.idCurso),
            usuario = usuarioService.buscaUsuarioPorID(topicoFormDTO.idUsuario)
        )
    }

}

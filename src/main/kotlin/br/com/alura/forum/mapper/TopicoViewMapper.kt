package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoViewDTO
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoViewDTO> {

    override fun map(topico: Topico): TopicoViewDTO {
        return TopicoViewDTO(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )
    }

}

package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicoFormDTO
import br.com.alura.forum.dto.TopicoViewDTO
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(), private val topicoViewMapper: TopicoViewMapper, private val topicoFormMapper: TopicoFormMapper
) {

    fun listaTopicos(): List<TopicoViewDTO> {
        return topicos.stream().map { topico -> topicoViewMapper.map(topico)}.collect(Collectors.toList())
    }

    fun buscaTopicoPorID(id: Long): TopicoViewDTO {
        val topico = topicos.stream().filter { topico -> topico.id == id }.findFirst().get()
        return topicoViewMapper.map(topico);
    }

    fun cadastraNovoTopico(topicoFormDTO: TopicoFormDTO) {
        val topico = topicoFormMapper.map(topicoFormDTO)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

}

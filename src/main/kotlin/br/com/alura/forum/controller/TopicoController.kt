package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicoFormDTO
import br.com.alura.forum.dto.TopicoViewDTO
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listaTopicos(): List<TopicoViewDTO> {
        return topicoService.listaTopicos();
    }

    @GetMapping("/{id}")
    fun listaTopicosPorID(@PathVariable id: Long): TopicoViewDTO {
        return topicoService.buscaTopicoPorID(id);
    }

    @PostMapping
    fun cadastraNovoTopico(@RequestBody @Valid topicoFormDTO: TopicoFormDTO) {
        topicoService.cadastraNovoTopico(topicoFormDTO);
    }

}

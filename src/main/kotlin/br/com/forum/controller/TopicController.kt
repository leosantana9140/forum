package br.com.forum.controller

import br.com.forum.dto.TopicFormDTO
import br.com.forum.dto.TopicViewDTO
import br.com.forum.dto.UpdateTopicFormDTO
import br.com.forum.service.TopicService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("topic")
@SecurityRequirement(name = "bearerAuth")
class TopicController(private val topicService: TopicService) {
    @GetMapping
    fun getTopics(@RequestParam(required = false) courseName: String?, @PageableDefault(size = 5, sort = ["creationDate"], direction = Sort.Direction.DESC) pageable: Pageable): Page<TopicViewDTO> {
        return topicService.getTopics(courseName, pageable);
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicViewDTO {
        return topicService.getTopicById(id);
    }

    @PostMapping
    @Transactional
    fun saveTopic(@RequestBody @Valid topicFormDTO: TopicFormDTO, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<TopicViewDTO> {
        val topicViewDTO = topicService.saveTopic(topicFormDTO);
        val uri = uriComponentsBuilder.path("/topics/${topicViewDTO.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicViewDTO);
    }

    @PutMapping
    @Transactional
    fun updateTopic(@RequestBody @Valid updateTopicFormDTO: UpdateTopicFormDTO): ResponseEntity<TopicViewDTO> {
        val topicViewDTO = topicService.updateTopic(updateTopicFormDTO)

        return ResponseEntity.ok(topicViewDTO)
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        topicService.deleteTopic(id);
    }
}

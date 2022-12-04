package br.com.forum.controller

import br.com.forum.dto.TopicByCategoryDTO
import br.com.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("report")
class ReportController(private val topicService: TopicService) {
    @GetMapping
    fun getReport(): List<TopicByCategoryDTO> {
        return topicService.getReport()
    }
}

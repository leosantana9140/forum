package br.com.forum.controller

import br.com.forum.dto.ReplyFormDTO
import br.com.forum.mapper.ReplyFormMapper
import br.com.forum.repository.TopicRepository
import br.com.forum.service.EmailService
import br.com.forum.service.ReplyService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("reply")
@SecurityRequirement(name = "bearerAuth")
class ReplyController(private val replyService: ReplyService, private val emailService: EmailService, private val topicRepository: TopicRepository, private val replyFormMapper: ReplyFormMapper) {
    @PostMapping
    fun saveReply(@RequestBody @Valid replyFormDTO: ReplyFormDTO) {
        val topicId = replyFormDTO.topicId
        val reply = replyFormMapper.map(replyFormDTO)
        replyService.saveReply(reply)

        val topic = topicRepository.findById(topicId).get()
        val userEmail = topic.user.email
        emailService.sendEmail(userEmail)
    }
}

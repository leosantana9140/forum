package br.com.forum.service

import br.com.forum.model.Reply
import br.com.forum.repository.ReplyRepository
import org.springframework.stereotype.Service

@Service
class ReplyService(private val replyRepository: ReplyRepository) {
    fun saveReply(reply: Reply) = replyRepository.save(reply)
}

package br.com.forum.mapper

import br.com.forum.dto.ReplyFormDTO
import br.com.forum.model.Reply
import br.com.forum.repository.TopicRepository
import org.springframework.stereotype.Component

@Component
class ReplyFormMapper(private val topicRepository: TopicRepository): Mapper<ReplyFormDTO, Reply> {
    override fun map(replyFormDTO: ReplyFormDTO): Reply {
        val topic = topicRepository.findById(replyFormDTO.topicId).get()

        return Reply(
            message = replyFormDTO.message,
            topic = topic,
            user = topic.user,
            isSolved = true
        )
    }
}

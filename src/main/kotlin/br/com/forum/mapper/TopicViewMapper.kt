package br.com.forum.mapper

import br.com.forum.dto.TopicViewDTO
import br.com.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicViewDTO> {
    override fun map(topic: Topic): TopicViewDTO {
        return TopicViewDTO(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            creationDate = topic.creationDate,
            status = topic.status,
            changeDate = topic.changeDate
        )
    }
}

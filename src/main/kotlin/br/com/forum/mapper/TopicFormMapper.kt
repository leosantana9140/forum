package br.com.forum.mapper

import br.com.forum.dto.TopicFormDTO
import br.com.forum.model.Topic
import br.com.forum.service.CourseService
import br.com.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(private val courseService: CourseService, private val userService: UserService): Mapper<TopicFormDTO, Topic> {
    override fun map(topicFormDTO: TopicFormDTO): Topic {
        return Topic(
            title = topicFormDTO.title,
            message = topicFormDTO.message,
            course = courseService.getCourseById(topicFormDTO.courseId),
            user = userService.getUserById(topicFormDTO.userId)
        )
    }
}

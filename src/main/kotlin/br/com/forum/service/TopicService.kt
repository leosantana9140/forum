package br.com.forum.service

import br.com.forum.dto.TopicByCategoryDTO
import br.com.forum.dto.TopicFormDTO
import br.com.forum.dto.TopicViewDTO
import br.com.forum.dto.UpdateTopicFormDTO
import br.com.forum.exception.NotFoundException
import br.com.forum.mapper.TopicFormMapper
import br.com.forum.mapper.TopicViewMapper
import br.com.forum.repository.TopicRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TopicService(private val topicRepository: TopicRepository, private val topicViewMapper: TopicViewMapper, private val topicFormMapper: TopicFormMapper, private val notFoundMessage: String = "Tópico não encontrado") {
    @Cacheable(cacheNames = ["topics"], key = "#root.method.name")
    fun getTopics(courseName: String?, pageable: Pageable): Page<TopicViewDTO> {
        val topics = if (courseName == null) {
            topicRepository.findAll(pageable)
        } else {
            topicRepository.findByCourseName(courseName, pageable)
        }

        return topics.map { topic -> topicViewMapper.map(topic) }
    }

    fun getTopicById(id: Long): TopicViewDTO {
        val topic = topicRepository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }

        return topicViewMapper.map(topic);
    }

    @CacheEvict(value = ["topics"], allEntries = true)
    fun saveTopic(topicFormDTO: TopicFormDTO): TopicViewDTO {
        val topic = topicFormMapper.map(topicFormDTO)
        topicRepository.save(topic)

        return topicViewMapper.map(topic)
    }

    @CacheEvict(value = ["topics"], allEntries = true)
    fun updateTopic(updateTopicFormDTO: UpdateTopicFormDTO): TopicViewDTO {
        val topic = topicRepository.findById(updateTopicFormDTO.id).orElseThrow { NotFoundException(notFoundMessage) }

        topic.title = updateTopicFormDTO.title
        topic.message = updateTopicFormDTO.message
        topic.changeDate = LocalDate.now()

        return topicViewMapper.map(topic)
    }

    @CacheEvict(value = ["topics"], allEntries = true)
    fun deleteTopic(id: Long) {
        topicRepository.deleteById(id)
    }

    fun getReport(): List<TopicByCategoryDTO> {
        return topicRepository.getReport()
    }
}

package br.com.forum.repository

import br.com.forum.dto.TopicByCategoryDTO
import br.com.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, pageable: Pageable): Page<Topic>

    @Query("SELECT new br.com.forum.dto.TopicByCategoryDTO(course.category, count(t)) FROM Topic t JOIN t.course course GROUP BY course.category")
    fun getReport(): List<TopicByCategoryDTO>

}

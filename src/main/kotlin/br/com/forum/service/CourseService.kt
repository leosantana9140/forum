package br.com.forum.service

import br.com.forum.model.Course
import br.com.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {
    fun getCourseById(id: Long): Course {
        return courseRepository.getOne(id)
    }
}

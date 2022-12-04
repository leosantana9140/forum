package br.com.forum.repository

import br.com.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long>

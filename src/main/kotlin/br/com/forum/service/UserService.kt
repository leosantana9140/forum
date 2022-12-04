package br.com.forum.service

import br.com.forum.model.User
import br.com.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(id: Long): User {
        return userRepository.getOne(id)
    }
}

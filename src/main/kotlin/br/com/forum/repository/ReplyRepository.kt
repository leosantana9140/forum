package br.com.forum.repository

import br.com.forum.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository: JpaRepository<Reply, Long>

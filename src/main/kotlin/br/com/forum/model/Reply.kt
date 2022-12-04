package br.com.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Reply(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val topic: Topic,
    @ManyToOne
    val user: User,
    val isSolved: Boolean
)

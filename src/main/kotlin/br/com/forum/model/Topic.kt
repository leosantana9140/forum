package br.com.forum.model

import br.com.forum.enums.TopicStatusEnum
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    var changeDate: LocalDate? = null,
    @ManyToOne
    val course: Course,
    @ManyToOne
    val user: User,
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatusEnum = TopicStatusEnum.NOT_ANSWERED,
    @OneToMany(mappedBy = "topic")
    val replies: List<Reply> = ArrayList()
)

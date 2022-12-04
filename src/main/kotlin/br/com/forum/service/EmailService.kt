package br.com.forum.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(private val javaMailSender: JavaMailSender) {
    fun sendEmail(userEmail: String) {
        val email = SimpleMailMessage()
        email.setSubject("[Fórum] Você recebeu uma resposta!")
        email.setText("Olá, o seu tópico foi respondido. Vamos lá conferir?")
        email.setTo(userEmail)

        javaMailSender.send(email)
    }
}

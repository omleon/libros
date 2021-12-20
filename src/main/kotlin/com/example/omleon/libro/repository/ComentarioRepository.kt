package com.example.omleon.libro.repository
import com.example.omleon.libro.model.Comentario
import org.springframework.data.jpa.repository.JpaRepository
interface ComentarioRepository: JpaRepository<Comentario, Long> {
    fun findById(id: Long?): Comentario?
}
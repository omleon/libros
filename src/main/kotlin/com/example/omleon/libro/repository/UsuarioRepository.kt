package com.example.omleon.libro.repository
import com.example.omleon.libro.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findById(id: Long?): Usuario?
}
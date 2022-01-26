package com.example.omleon.libro.repository
import com.example.omleon.libro.model.Credenciales
import com.example.omleon.libro.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CredencialesRepository: JpaRepository<Credenciales, Long> {
    fun findById(id: Long?): Usuario?

    @Query(value = "SELECT * FROM credenciales u WHERE u.username = :username",
            nativeQuery = true)
    fun findByUsername(username: String?): Credenciales?
}
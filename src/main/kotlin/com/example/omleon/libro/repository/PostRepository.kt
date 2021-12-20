package com.example.omleon.libro.repository
import com.example.omleon.libro.model.Post
import org.springframework.data.jpa.repository.JpaRepository
interface PostRepository: JpaRepository<Post, Long> {
    fun findById(id: Long?): Post?
}
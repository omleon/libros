package com.example.omleon.libro.service

import com.example.omleon.libro.model.Post
import com.example.omleon.libro.repository.PostRepository
import com.example.omleon.libro.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.Exception

@Service
class PostService {
    @Autowired
    lateinit var postRepository: PostRepository

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    fun list(): List<Post> {
        return postRepository.findAll()
    }
    fun save(post: Post): Post {
        try {
                post.titulo?.takeIf { it.trim().isNotEmpty()}
                    ?: throw Exception("No debe estar vacio")
            post.autor?.takeIf { it.trim().isNotEmpty()}
                ?: throw Exception("No debe estar vacio")

            return postRepository.save(post)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(post: Post):Post{
        try {

            val response = postRepository.findById(post.id)
                    ?: throw Exception("El id ${post.id}  no existe")

            if (post.titulo.equals("") || post.titulo.equals("")
                    || post.autor.equals("")){
                throw Exception( "Alguno de los capos están vacios")
            }

            else {
                return postRepository.save(post)
            }
        } catch(ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun updateDescription (post: Post):Post {
        val response = postRepository.findById(post.id)
                ?: throw Exception()
        response.apply {
            this.titulo=post.titulo
        }
        return postRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        postRepository.deleteById(id)
        return true
    }
}
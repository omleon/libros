package com.example.omleon.libro.service
import com.example.omleon.libro.model.Post
import com.example.omleon.libro.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception
@Service
class PostService {
    @Autowired
    lateinit var postRepository: PostRepository
    fun list(): List<Post> {
        return postRepository.findAll()
    }
    fun save(post: Post): Post {
        try {
            post.titulo?.trim()?.isEmpty()
                    ?: throw java.lang.Exception("Nop puede ser vacio")

            val response = postRepository.findById(post.id)
                    ?: throw Exception("El id ${post.id} en post no existe")
            response.apply {
                this.titulo = post.titulo
            }
            return postRepository.save(post)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(post: Post):Post{
        return  postRepository.save(post)
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
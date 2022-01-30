package com.example.omleon.libro.service

import com.example.omleon.libro.model.Comentario
import com.example.omleon.libro.repository.ComentarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception

@Service
class ComentarioService {
    @Autowired
    lateinit var comentarioRepository: ComentarioRepository
    fun list(): List<Comentario> {
        return comentarioRepository.findAll()
    }
    fun save(comentario: Comentario): Comentario {
        try {
            comentario.fechapublicacion?.takeIf { it.trim().isNotEmpty()}
                ?: throw Exception("No debe estar vacio")
            comentario.fechapublicacion?.takeIf { it.trim().isNotEmpty()}
                ?: throw Exception("No debe estar vacio")

            return comentarioRepository.save(comentario)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(comentario: Comentario): Comentario {
        try {

            val response = comentarioRepository.findById(comentario.id)
                    ?: throw Exception("El id ${comentario.id}  no existe")

            if (comentario.fechapublicacion.equals("") || comentario.fechapublicacion.equals("")
                    || comentario.caracteres.equals("")){
                throw Exception( "Alguno de los capos están vacios")
            }

            else {
                return comentarioRepository.save(comentario)
            }
        } catch(ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun updateDescription (comentario: Comentario): Comentario {
        val response = comentarioRepository.findById(comentario.id)
                ?: throw Exception()
        response.apply {
            this.caracteres=comentario.caracteres
        }
        return comentarioRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        comentarioRepository.deleteById(id)
        return true
    }
}
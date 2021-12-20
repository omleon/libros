package com.example.omleon.libro.service
import com.example.omleon.libro.model.Usuario
import com.example.omleon.libro.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
//import java.lang.Exception
//import kotlin.Exception

@Service
class UsuarioService {
    /*
    @Autowired
    lateinit var lectoresRepository: LectoresRepository
 */
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    fun list(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun save(usuario: Usuario): Usuario {
        if(usuario.comentarios .equals("" )){
            throw   Exception()
        }
        else {
            return usuarioRepository.save(usuario)
        }
    }
    fun update(usuario: Usuario): Usuario {
        return  usuarioRepository.save(usuario)
    }

    fun updateDescription (usuario: Usuario): Usuario {
        try{
        val response = usuarioRepository.findById(usuario.id)
                ?: throw Exception()
        response.apply {
            this.nombre=usuario.nombre
        }
        return usuarioRepository.save(usuario)
    }
catch(ex: Exception){
    throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "No Encontrada", ex)
}
    }

    fun delete (id:Long): Boolean{
        usuarioRepository.deleteById(id)
        return true
    }
}
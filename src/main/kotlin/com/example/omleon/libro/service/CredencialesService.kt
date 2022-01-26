package com.example.omleon.libro.service
import com.example.omleon.libro.model.Credenciales
import com.example.omleon.libro.model.Usuario
import com.example.omleon.libro.repository.CredencialesRepository
import com.example.omleon.libro.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service
class CredencialesService {
    @Autowired
    lateinit var credencialesRepository: CredencialesRepository
    fun getCredenciales(username:String?): Credenciales?{
        return credencialesRepository.findByUsername(username)
    }
}
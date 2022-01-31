package com.example.omleon.libro.service

import com.example.omleon.libro.model.Comentario
import com.example.omleon.libro.model.Usuario
import com.example.omleon.libro.repository.ComentarioRepository
import com.example.omleon.libro.repository.UsuarioRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class DietServiceEva {
    @InjectMocks
    lateinit var usuarioService: UsuarioService

    @Mock
    lateinit var usuarioRepository: UsuarioRepository

    val jsonString = File("./src/test/resources/usuario/crearUsuario.json").readText(Charsets.UTF_8)
    val usuarioMock = Gson().fromJson(jsonString, Usuario::class.java)
    @Test
    fun updateIsCorrect(){
     //   Mockito.`when`(usuarioRepository.findById(usuarioMock.id)).thenReturn(usuarioMock)
        Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
        val response = usuarioService.update(usuarioMock)
        Assertions.assertEquals(response.id, usuarioMock.id)
        Assertions.assertEquals(response.nombre, usuarioMock.nombre)

    }
    @Test
    fun updateIsFailed(){
        usuarioMock.apply {
            nombre=" "
        }
      //  Mockito.`when`(usuarioRepository.findById(usuarioMock.id)).thenReturn(usuarioMock)
        Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
        val response = usuarioService.update(usuarioMock)
        Assertions.assertEquals(response.id, usuarioMock.id)
        Assertions.assertEquals(response.nombre, usuarioMock.nombre)
    }

}
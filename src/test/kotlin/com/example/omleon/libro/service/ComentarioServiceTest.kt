package com.example.omleon.libro.service

import com.example.omleon.libro.model.Comentario
import com.example.omleon.libro.repository.ComentarioRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class ComentarioServiceTest {
    @InjectMocks
    lateinit var comentarioService: ComentarioService

    @Mock
    lateinit var comentarioRepository: ComentarioRepository

    val jsonString = File("./src/test/resources/comentario/crearComentario.json").readText(Charsets.UTF_8)
    val comentarioMock = Gson().fromJson(jsonString, Comentario::class.java)

    @Test
    fun createComentario(){

        // Mockito.`when`(personRepository.findById(dietMock.person_id)).thenReturn(personMock)

        Mockito.`when`(comentarioRepository.save(Mockito.any(Comentario::class.java))).thenReturn(comentarioMock)
        val response = comentarioService.save(comentarioMock)
        Assertions.assertEquals(response.id, comentarioMock.id)
        Assertions.assertEquals(response.fechapublicacion, comentarioMock.fechapublicacion)
    }
    @Test
    fun createComentarioFailed() {
        Assertions.assertThrows(Exception::class.java) {
            comentarioMock.apply { fechapublicacion = "   " }
            Mockito.`when`(comentarioRepository.save(Mockito.any(Comentario::class.java))).thenReturn(comentarioMock)
            comentarioService.save(comentarioMock)
        }
    }
}
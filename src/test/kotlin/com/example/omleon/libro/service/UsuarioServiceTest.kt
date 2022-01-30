package com.example.omleon.libro.service

import com.example.omleon.libro.model.Usuario
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
class UsuarioServiceTest {
    @InjectMocks
    lateinit var usuarioService: UsuarioService

    @Mock
    lateinit var usuarioRepository: UsuarioRepository

    val jsonString = File("./src/test/resources/usuario/crearUsuario.json").readText(Charsets.UTF_8)
    val usuarioMock = Gson().fromJson(jsonString, Usuario::class.java)

    @Test
    fun createUsuario(){

        // Mockito.`when`(personRepository.findById(dietMock.person_id)).thenReturn(personMock)

        Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
        val response = usuarioService.save(usuarioMock)
        Assertions.assertEquals(response.id, usuarioMock.id)
        Assertions.assertEquals(response.nombre, usuarioMock.nombre)
    }
    @Test
    fun createUsuarioFailed() {
        Assertions.assertThrows(Exception::class.java) {
            usuarioMock.apply { nombre = "   " }
            Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
            usuarioService.save(usuarioMock)
        }
    }

}

/*  @Autowired
  lateinit var  usuarioService: UsuarioService

@Test
  fun calcMultiplicationIfIsPair (){
  val response = usuarioService.calcMultiplication(2,2)
  Assertions.assertEquals(4,response)
  }

  @Test
  fun calcMultiplicationIfIsNoPair (){
      val response = usuarioService.calcMultiplication(1,4)
      Assertions.assertEquals(4,response)
  }
  @Test
  fun restNineXxx(){
      val response= usuarioService.restNine(8)
      Assertions.assertEquals(8,response)
  }
  @Test
  fun restNineXxxx(){
      val response= usuarioService.restNine(10)
      Assertions.assertEquals(1,response)
  }
  @Test
  fun subtactFronNextTenXxx(){
      val response= usuarioService.subtactFronNextTenXxx(14)
      Assertions.assertEquals(6,response)
  }
  @Test
  fun validarCedula(){
      val response = usuarioService.validarCedula("0301707030")
      Assertions.assertEquals(true,response)
  }
  @Test
  fun validarCedulaFalso(){
      val response = usuarioService.validarCedula("0150265755")
      Assertions.assertEquals(false,response)
  }*/

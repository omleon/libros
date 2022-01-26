package com.example.omleon.libro.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UsuarioServiceTest {
    @Autowired
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
    }
}

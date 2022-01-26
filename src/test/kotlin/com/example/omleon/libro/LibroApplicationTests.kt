package com.example.omleon.libro

import com.example.omleon.libro.service.UsuarioService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LibroApplicationTests {
	@Autowired
	lateinit var  usuarioService: UsuarioService

	@Test
	fun contextLoads() {

	}

	@Test
	fun verifySizeWordWhenIsCorrect(){
		val response: Boolean = usuarioService.verifyWord("ABCD")
		Assertions.assertEquals(true, response)
	}
}

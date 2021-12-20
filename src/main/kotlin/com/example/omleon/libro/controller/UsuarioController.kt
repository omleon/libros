package com.example.omleon.libro.controller
import com.example.omleon.libro.model.Usuario
import com.example.omleon.libro.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/usuario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class UsuarioController {
    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping
        fun list(): List<Usuario>{
        return usuarioService.list()
    }
    @PostMapping
    fun save(@RequestBody usuario: Usuario): Usuario {
        return usuarioService.save(usuario)
    }
    @PutMapping
    fun update (@RequestBody usuario: Usuario): Usuario {
        return usuarioService.update(usuario)
    }
    @PatchMapping
    fun updaateDescription (@RequestBody usuario: Usuario): Usuario {
        return  usuarioService.updateDescription(usuario)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return usuarioService.delete(id)
    }
}
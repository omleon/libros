package com.example.omleon.libro.controller
import com.example.omleon.libro.model.Comentario
import com.example.omleon.libro.service.ComentarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/comentario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ComentarioController {
    @Autowired
    lateinit var comentarioService: ComentarioService

    @GetMapping
    fun list(): List<Comentario>{
        return comentarioService.list()
    }
    @PostMapping
    fun save(@RequestBody comentario: Comentario): Comentario {
        return comentarioService.save(comentario)
    }
    @PutMapping
    fun update (@RequestBody comentario: Comentario): Comentario {
        return comentarioService.update(comentario)
    }
    @PatchMapping
    fun updaateDescription (@RequestBody comentario: Comentario): Comentario {
        return  comentarioService.updateDescription(comentario)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return comentarioService.delete(id)
    }
}

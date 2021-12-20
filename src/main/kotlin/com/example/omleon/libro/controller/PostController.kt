package com.example.omleon.libro.controller
import com.example.omleon.libro.model.Post
import com.example.omleon.libro.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/post")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])
class PostController {
    @Autowired
    lateinit var postService: PostService

    @GetMapping
    fun list(): List<Post>{
        return postService.list()
    }
    @PostMapping
    fun save(@RequestBody post: Post): Post{
        return postService.save(post)
    }
    @PutMapping
    fun update (@RequestBody post: Post):Post{
        return postService.update(post)
    }
    @PatchMapping
    fun updaateDescription (@RequestBody post: Post): Post{
        return  postService.updateDescription(post)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return postService.delete(id)
    }
}
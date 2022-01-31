package com.example.omleon.libro.service

import com.example.omleon.libro.model.Post
import com.example.omleon.libro.model.Usuario
import com.example.omleon.libro.repository.PostRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class PostServiceTest {

    @InjectMocks
    lateinit var postService: PostService

    @Mock
    lateinit var postRepository: PostRepository

    val jsonString = File("./src/test/resources/post/crearPost.json").readText(Charsets.UTF_8)
    val postMock = Gson().fromJson(jsonString, Post::class.java)

    @Test
    fun createPost(){

       // Mockito.`when`(personRepository.findById(dietMock.person_id)).thenReturn(personMock)

        Mockito.`when`(postRepository.save(Mockito.any(Post::class.java))).thenReturn(postMock)
        val response = postService.save(postMock)
        Assertions.assertEquals(response.id, postMock.id)
        Assertions.assertEquals(response.titulo, postMock.titulo)
    }
    @Test
    fun createPostFailed() {
        Assertions.assertThrows(Exception::class.java) {
            postMock.apply { titulo = "   " }
            Mockito.`when`(postRepository.save(Mockito.any(Post::class.java))).thenReturn(postMock)
            postService.save(postMock)
        }
    }
    @Test
    fun updateIsCorrect(){
        Mockito.`when`(postRepository.findById(postMock.id)).thenReturn(postMock)
        Mockito.`when`(postRepository.save(Mockito.any(Post::class.java))).thenReturn(postMock)
        val response = postService.update(postMock)
        Assertions.assertEquals(response.id, postMock.id)
        Assertions.assertEquals(response.titulo, postMock.titulo)
    }
    @Test
    fun updateIsFailed(){
        postMock.apply {
            titulo=" "
        }
        Mockito.`when`(postRepository.findById(postMock.id)).thenReturn(postMock)
        Mockito.`when`(postRepository.save(Mockito.any(Post::class.java))).thenReturn(postMock)
        val response = postService.update(postMock)
        Assertions.assertEquals(response.id, postMock.id)
        Assertions.assertEquals(response.titulo, postMock.titulo)
    }
    @Test
    fun updateIsFailedWhenIdDoesntExist(){
        postMock.apply {
            id=2
        }
        Mockito.`when`(postRepository.findById(postMock.id)).thenReturn(postMock)
        Mockito.`when`(postRepository.save(Mockito.any(Post::class.java))).thenReturn(postMock)
        val response = postService.update(postMock)
        Assertions.assertEquals(response.id, postMock.id)
        Assertions.assertEquals(response.titulo, postMock.titulo)
    }
}
/*
@InjectMocks
lateinit var postService: PostService

@Mock
lateinit var postRepository: PostRepository


val returnObject: Post = Post().apply {
                                id=1
                                titulo="Saba"
                                autor="Juan"
                                fecha= "10/5/2016"
}
val newObject: Post = Post().apply {
    id=1
    titulo="Saba"
    autor="Juan"
    fecha= "10/5/2016"
}
@Test
fun saveIsCorrect(){
    Mockito.`when`(postRepository.save(Mockito.any(Post::class.java))).thenReturn(returnObject)
    val response = postService.save(newObject)
    Assertions.assertEquals(response.id, newObject.id)
    Assertions.assertEquals(response.titulo, newObject.titulo)
}*/
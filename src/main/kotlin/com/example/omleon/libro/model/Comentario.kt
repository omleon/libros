package com.example.omleon.libro.model

import javax.persistence.*

@Entity
@Table(name = "comentario")
class Comentario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fechapublicacion: String? = null
    var caracteres: String? = null
    @Column(name="post_id")
    var post_id: Long? = null
}
package com.example.omleon.libro.model

import javax.persistence.*

@Entity
@Table(name = "post")
class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var titulo: String? = null
    var autor: String? = null
    var fecha: String? = null
    @Column(name="usuario_id")
    var usuario_id: Long? = null
}
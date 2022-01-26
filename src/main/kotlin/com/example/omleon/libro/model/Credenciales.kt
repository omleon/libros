package com.example.omleon.libro.model

import javax.persistence.*

@Entity
@Table(name = "credenciales")
class Credenciales {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var username: String? = null
    var password: String? = null

}
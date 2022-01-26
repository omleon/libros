package com.example.omleon.libro.service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service

class GymUserDetailsService: UserDetailsService {
    @Autowired
    lateinit var credencialesService: CredencialesService

    override fun loadUserByUsername(username: String?): UserDetails {
        val response=credencialesService.getCredenciales(username)
        return User(response?.username,"{noop}"+response?.password, ArrayList())
    }

}
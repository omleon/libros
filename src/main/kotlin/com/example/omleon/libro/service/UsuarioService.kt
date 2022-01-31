package com.example.omleon.libro.service
import com.example.omleon.libro.model.Usuario
import com.example.omleon.libro.repository.UsuarioRepository
import org.jetbrains.annotations.TestOnly
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    fun list(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun save(usuario: Usuario): Usuario {
        try {
            usuario.nombre?.takeIf { it.trim().isNotEmpty()}
                ?: throw Exception("No debe estar vacio")
            usuario.nombre?.takeIf { it.trim().isNotEmpty()}
                ?: throw Exception("No debe estar vacio")

            return usuarioRepository.save(usuario)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(usuario: Usuario): Usuario {
        try {

            val response = usuarioRepository.findById(usuario.id)
                    ?: throw Exception("El id ${usuario.id}  no existe")

            if (usuario.nombre.equals("") || usuario.nombre.equals("")
                    || usuario.comentarios.equals("")){
                throw Exception( "Alguno de los capos están vacios")
            }

            else {
                return usuarioRepository.save(usuario)
            }
        } catch(ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun updateDescription (usuario: Usuario): Usuario {
        try{
        val response = usuarioRepository.findById(usuario.id)
                ?: throw Exception()
        response.apply {
            this.nombre=usuario.nombre
        }
        return usuarioRepository.save(usuario)
    }
catch(ex: Exception){
    throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "No Encontrada", ex)
}
    }

    fun delete (id:Long): Boolean{
        usuarioRepository.deleteById(id)
        return true
    }

    fun verifyWord(comentario: String?):Boolean{
        if (comentario.equals("")) {
        return false
        }
        return true
    }
    fun calcMultiplication (index: Int, number:Int):Int {
        if (index %2 == 0) {
            return number * 2
        }
        else{
        return number
        }
    }
    fun restNine(number: Int):Int{
        if(number in 10..18){
            return number - 9
        }
        return number
    }
    fun subtactFronNextTenXxx(number: Int):Int{
        var decena=(number/10)+1
        var response = (decena*10)-number
        if(response ==10){
            return 0
        }
        return response
    }


    fun verifyWordd(nombre: String?):Boolean{
        if (nombre.equals("")) {
            return false
        }
        return true
    }



    fun validaUsuario(nombre: String?):Boolean{
        val lista= listOf<String>("Juan","Maria","Victor")
        for (nombre.equals(lista)){
            return false
        }
        return true
    }


    fun validarCedula(x: String):Boolean{
        var suma=0
        return  if (x.length==9)
        {
            println("Ingrese su cedula")

            false
        }

        else
        {
            val a = IntArray(x.length/2)

            val b = IntArray(x.length/2)

            var c = 0

            var d = 1

            for (i in 0 until x.length/2){

                a[1]= x[c].toString().toInt() //<-- esto combierte a entero

                c +=2

                if(1< x.length/2 - 1){

                    b[i]=x[d].toString().toInt()

                    d +=2
                }
            }

            for (i in a.indices)
            {
                a[i]= a[i]*2
                if(a[i]>9)
                {
                    a[i]=a[i]-9
                }
                suma=suma+a[i]+b[i]
            }


            val aux = suma/10
            val dec = (aux+1)*10
            if(dec-suma ==x[x.length-1].toString()
                    .toInt()
            )true else suma % 10 == 0 && x[x.length-1]=='0'
        }
    }

}
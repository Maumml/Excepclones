// Paso 1: Excepciones personalizadas
class UsuarioNoEncontradoException(mensaje: String) : Exception(mensaje)
class ContrasenaIncorrectaException(mensaje: String) : Exception(mensaje)

// Paso 2: Base de datos simulada
val baseDeDatosUsuarios = mapOf(
    "admin" to "1234",
    "mauricio" to "sistemas2025",
    "usuarioX" to "claveSegura"
)

// Paso 3: Lógica de autenticación
fun iniciarSesion(usuario: String, contrasena: String): String {
    if (!baseDeDatosUsuarios.containsKey(usuario)) {
        throw UsuarioNoEncontradoException("Usuario '$usuario' no encontrado.")
    }

    val contrasenaReal = baseDeDatosUsuarios[usuario]
    if (contrasenaReal != contrasena) {
        throw ContrasenaIncorrectaException("Contraseña incorrecta para el usuario '$usuario'.")
    }

    return "Bienvenido, $usuario. Token: [TOKEN_SIMULADO]"
}

// Paso 4: Función main para probar varios casos
fun main() {
    val intentos = listOf(
        Pair("admin", "1234"),                 // Correcto
        Pair("usuarioX", "claveMala"),         // Contraseña incorrecta
        Pair("desconocido", "loquesea")        // Usuario inexistente
    )

    for ((usuario, contrasena) in intentos) {
        println("Intentando iniciar sesión con usuario: '$usuario'")

        try {
            try {
                val resultado = iniciarSesion(usuario, contrasena)
                println(resultado)
            } catch (e: ContrasenaIncorrectaException) {
                println("Error: ${e.message}")
            }
        } catch (e: UsuarioNoEncontradoException) {
            println("Error: ${e.message}")
        } finally {
            println("Intento de inicio de sesión registrado.\n")
        }
    }
}
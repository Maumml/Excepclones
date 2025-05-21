// Paso 1: Excepciones personalizadas
class NombreInvalidoException(mensaje: String) : Exception(mensaje)
class EmailInvalidoException(mensaje: String) : Exception(mensaje)
class EdadInvalidaException(mensaje: String) : Exception(mensaje)

// Paso 2: Función que valida el formulario
fun registrarUsuario(nombre: String, email: String, edad: Int) {
    if (nombre.isBlank()) {
        throw NombreInvalidoException("El nombre no puede estar vacío.")
    }
    if (!email.contains("@")) {
        throw EmailInvalidoException("El correo electrónico no es válido.")
    }
    if (edad <= 0) {
        throw EdadInvalidaException("La edad debe ser un número positivo.")
    }

    println("Usuario registrado exitosamente: $nombre, $email, $edad años.")
}

// Paso 3: main con múltiples catch
fun main() {
    val pruebas = listOf(
        Triple("", "juan@example.com", 25),          // Nombre inválido
        Triple("Ana", "anaexample.com", 30),         // Email inválido
        Triple("Luis", "luis@example.com", -5),      // Edad inválida
        Triple("Carlos", "carlos@example.com", 22)   // Datos válidos
    )

    for ((nombre, email, edad) in pruebas) {
        println("Validando registro: $nombre, $email, $edad")

        try {
            registrarUsuario(nombre, email, edad)
        } catch (e: NombreInvalidoException) {
            println("ERROR: ${e.message}")
        } catch (e: EmailInvalidoException) {
            println("ERROR: ${e.message}")
        } catch (e: EdadInvalidaException) {
            println("ERROR: ${e.message}")
        } finally {
            println("Proceso de validación finalizado.\n")
        }
    }
}
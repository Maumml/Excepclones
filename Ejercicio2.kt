import java.io.*

// Paso 1: Definir excepciones personalizadas
class ArchivoNoEncontradoException(mensaje: String) : IOException(mensaje)
class ErrorDeLecturaException(mensaje: String) : IOException(mensaje)

// Paso 2: Función que intenta leer un archivo línea por línea
fun leerArchivo(ruta: String): List<String> {
    try {
        val archivo = File(ruta)
        if (!archivo.exists()) {
            throw ArchivoNoEncontradoException("Archivo no encontrado en la ruta: $ruta")
        }

        return archivo.readLines()

    } catch (e: FileNotFoundException) {
        throw ArchivoNoEncontradoException("Archivo no encontrado: ${e.message}")
    } catch (e: IOException) {
        throw ErrorDeLecturaException("Error de lectura: ${e.message}")
    }
}

// Paso 3: Función principal que invoca leerArchivo y maneja las excepciones
fun main() {
    val rutaArchivo = "ejemplo.txt" // Cambia esto por una ruta válida o inválida

    try {
        val lineas = leerArchivo(rutaArchivo)
        println("Contenido del archivo:")
        lineas.forEach { println(it) }

    } catch (e: ArchivoNoEncontradoException) {
        println("${e.message}")
    } catch (e: ErrorDeLecturaException) {
        println("${e.message}")
    } finally {
        println("Proceso de lectura terminado.")
    }
}
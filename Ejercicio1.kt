// Paso 1: Definir una excepción personalizada
class DivisionPorCeroException(mensaje: String) : ArithmeticException(mensaje)

// Paso 2: Función que realiza la división segura
fun dividir(a: Int, b: Int): Int {
    if (b == 0) {
        throw DivisionPorCeroException("Error: No se puede dividir por cero.")
    }
    return a / b
}

// Paso 3: Función main con manejo de excepciones
fun main() {
    val numerador = 10
    val denominador = 0

    try {
        val resultado = dividir(numerador, denominador)
        println("Resultado de la división: $resultado")
    } catch (e: DivisionPorCeroException) {
        println("¡Ocurrió un error! ${e.message}")
    } finally {
        println("Proceso de división finalizado.")
    }

    // El programa continúa...
    println("El programa sigue ejecutándose con normalidad.")
}
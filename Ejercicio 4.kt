import kotlin.random.Random

// Paso 1: Excepciones personalizadas
class PagoRechazadoException(mensaje: String) : Exception(mensaje)
class FondosInsuficientesException(mensaje: String) : Exception(mensaje)
class MonedaInvalidaException(mensaje: String) : Exception(mensaje)

// Paso 2: Clase Orden
class Orden(val id: Int) {

    fun procesarPago() {
        val resultado = Random.nextInt(0, 4) // 0 a 3
        when (resultado) {
            0 -> throw PagoRechazadoException("El banco rechazó el pago para la orden #$id.")
            1 -> throw FondosInsuficientesException("No hay fondos suficientes para pagar la orden #$id.")
            2 -> throw MonedaInvalidaException("La moneda usada es inválida para la orden #$id.")
            else -> println("Orden #$id: Pago procesado exitosamente.")
        }
    }
}

// Paso 3: main() con múltiples bloques catch
fun main() {
    val ordenes = listOf(Orden(101), Orden(102), Orden(103), Orden(104))

    for (orden in ordenes) {
        println("Procesando orden #${orden.id}...")

        try {
            orden.procesarPago()
        } catch (e: PagoRechazadoException) {
            println("ERROR: ${e.message}")
            println("Acción: Orden #${orden.id} cancelada.")
        } catch (e: FondosInsuficientesException) {
            println("⚠ADVERTENCIA: ${e.message}")
            println("Acción: Intentar de nuevo con otro método de pago.")
        } catch (e: MonedaInvalidaException) {
            println("ERROR: ${e.message}")
            println("Acción: Solicitar cambio de moneda.")
        } finally {
            println("Orden #${orden.id} ha sido cerrada.\n")
        }
    }
}

package ar.edu.tadp.viajes

object MenorCosto extends Criterio {
  override def seleccionarRecorrido(recorridos: List[List[Tramo]], unUsuario: Usuario): List[Tramo] = {
    var recorridoSeleccionado: List[Tramo] = null
    var tarifaConDescuento: Float = 0
    var tarifaConDescuentoAnt: Float = 0
    var first: Boolean = true

    for (unRecorrido <- recorridos) {
      if (first) {
        recorridoSeleccionado = unRecorrido
        first = false
      } else {
        tarifaConDescuento = unUsuario.calcularDescuento(unRecorrido)
        tarifaConDescuentoAnt = unUsuario.calcularDescuento(recorridoSeleccionado)

        if (tarifaConDescuentoAnt < tarifaConDescuento) {
          recorridoSeleccionado = unRecorrido
        }
      }
    }

    return recorridoSeleccionado
  }
}
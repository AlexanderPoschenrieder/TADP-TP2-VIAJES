package ar.edu.tadp.viajes

class Viaje(var origen: Direccion, var destino: Direccion, var usuario: Usuario) {
  def armarRecorrido() = {
    var mediosCercaOrigen: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(origen)
    var mediosCercaDestino: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(destino)
    var mediosPosibles: List[TransporteCerca] = chequearMedios(mediosCercaOrigen, mediosCercaDestino)

    if (mediosPosibles.isEmpty) { //Logica de combinacion
      //      return List()
    } else if (mediosPosibles.length == 1) {
      var transporteElegidoFiltrado: List[TransporteCerca] = mediosCercaDestino.filter(p => p.transporte.esIgual(mediosPosibles.head.transporte))
      var transporteElegido: TransporteCerca = transporteElegidoFiltrado.head
      var unTramo: Tramo = new Tramo(transporteElegido.transporte, mediosPosibles.head.direccion, transporteElegido.direccion)
      //      return List(unTramo)
    } else {
      //      usuario.criterio.armarRecorrido(origen, destino)
    }
  }

  def calcularCosto(): Float = {
    return 0
  }

  def calcularDistancia(): Int = {
    return 0
  }

  def calcularTiempo(): Int = {
    return 0
  }

  /*
   * Chequea si algun transporte que se toma en el origen es el mismo que los que se indican en el destino.
   */
  private def chequearMedios(mediosOrigen: List[TransporteCerca], mediosDestino: List[TransporteCerca]): List[TransporteCerca] = {
    var mediosPosibles: List[TransporteCerca] = List()

    for (a <- mediosOrigen) {
      for (b <- mediosDestino) {
        if (a.transporte.esIgual(b.transporte)) {
          mediosPosibles = b :: mediosPosibles
        }
      }
    }

    return mediosPosibles
  }
}
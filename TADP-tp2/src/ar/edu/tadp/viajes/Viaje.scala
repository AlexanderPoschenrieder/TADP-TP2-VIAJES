package ar.edu.tadp.viajes

class Viaje(var origen: Direccion, var destino: Direccion, var usuario: Usuario) {
  def armarRecorrido(): List[Tramo] = {
    var mediosCercaOrigen: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(origen)
    var mediosCercaDestino: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(destino)
    var mediosPosibles: List[TransporteCerca] = chequearMedios(mediosCercaOrigen, mediosCercaDestino)
    var posiblesRecorridos: List[List[Tramo]] = List()
    var unRecorrido: List[Tramo] = null

    for (a <- mediosPosibles) {
      unRecorrido = List()
      unRecorrido = crearTramo(mediosCercaDestino, a) :: unRecorrido
      posiblesRecorridos = unRecorrido :: posiblesRecorridos
    }

    if (posiblesRecorridos.isEmpty) { //Logica de combinacion
      return List()
    } else if (posiblesRecorridos.length == 1) {
      return posiblesRecorridos.head
    } else {
      return usuario.seleccionarRecorrido(posiblesRecorridos)
    }
  }

  private def crearTramo(mediosCercaDestino: List[TransporteCerca], medioPosible: TransporteCerca): Tramo = {
    var transporteElegidoFiltrado: List[TransporteCerca] = mediosCercaDestino.filter(p => p.transporte.esIgual(medioPosible.transporte))
    var transporteElegido: TransporteCerca = transporteElegidoFiltrado.head

    return new Tramo(transporteElegido.transporte, medioPosible.direccion, transporteElegido.direccion)
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
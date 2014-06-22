package ar.edu.tadp.viajes

object MenorCosto extends Criterio {
  override def armarRecorrido(origen: Direccion, destino: Direccion): List[TransporteCerca] = {
    var mediosCercaOrigen: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(origen)
    var mediosCercaDestino: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(destino)
    var mediosPosibles: List[TransporteCerca] = chequearMedios(mediosCercaOrigen, mediosCercaDestino)

//    if (mediosPosibles.isEmpty) {
//      //Logica de combinacion
//    } else if (mediosPosibles.length == 1) {
      return mediosPosibles
//    } else {
//      //Logica del criterio
//
//    }
  }

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
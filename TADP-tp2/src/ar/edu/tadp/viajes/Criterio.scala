package ar.edu.tadp.viajes

abstract class Criterio {
  def armarRecorrido(origen: Direccion, destino: Direccion): List[TransporteCerca] = {
    return List()
  }
}
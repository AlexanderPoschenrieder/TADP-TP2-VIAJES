package ar.edu.tadp.viajes

import ar.edu.tadp.viajes.ModuloTransporte

class Viaje(var origen: Direccion, var destino: Direccion, var usuario: Usuario) {
  def armarRecorrido() = {
    usuario.criterio.armarRecorrido(origen, destino)
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
}
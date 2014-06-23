package ar.edu.tadp.viajes

abstract class Criterio {
  def seleccionarRecorrido(recorridos: List[List[Tramo]], unUsuario: Usuario): List[Tramo] = {
    return List()
  }
}
package ar.edu.tadp.viajes

abstract class Transporte {
  def calcularTarifa(origen: Direccion, destino: Direccion): Float = {
    return 0
  }

  def esIgual(unTransporte: Transporte): Boolean = {
    return false
  }
}
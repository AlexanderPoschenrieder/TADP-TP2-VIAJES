package ar.edu.tadp.viajes

class Colectivo(var linea: Int) extends Transporte {
  override def calcularTarifa(origen: Direccion, destino: Direccion): Float = {
    return 1
  }

  override def esIgual(unTransporte: Transporte): Boolean = {
    var retVal: Boolean = false

    if (unTransporte.isInstanceOf[Colectivo]) {
      retVal = unTransporte.asInstanceOf[Colectivo].linea == this.linea
    }

    return retVal
  }
}
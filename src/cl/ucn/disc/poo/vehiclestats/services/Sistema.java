// (c) 2024 Departamento de Ingenieria de Sistemas y Computacion
package cl.ucn.disc.poo.vehiclestats.services;

import cl.ucn.disc.poo.vehiclestats.model.Automovil;
import cl.ucn.disc.poo.vehiclestats.model.Camion;
import cl.ucn.disc.poo.vehiclestats.model.Motocicleta;
import cl.ucn.disc.poo.vehiclestats.model.TipoCamion;
import cl.ucn.disc.poo.vehiclestats.model.TipoVehiculo;
import cl.ucn.disc.poo.vehiclestats.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Sistema.
 *
 * @author Departamento de Ingenieria de Sistemas y Computacion
 */
public final class Sistema {

  /** The list of vehicles. */
  private final List<Vehiculo> vehiculos = new ArrayList<>();

  /** El constructor. */
  public Sistema() {
    // Nothing here.
  }

  /**
   * Agrega un vehiculo al Sistema.
   *
   * @param vehiculo a agregar.
   */
  public void agregarVehiculo(Vehiculo vehiculo) {
    this.vehiculos.add(vehiculo);
  }

  /**
   * @return el promedio de la capacidad del motor.
   */
  public double calcularPromedioDeCapacidadDelMotor() {
    // suma
    double suma = 0;

    // contador
    int contador = 0;

    // ciclo para recorrer todos los vehiculos
    for (Vehiculo vehiculo : this.vehiculos) {

      // si el vehiculo es un automovil
      if (vehiculo instanceof Automovil automovil) {
        suma += automovil.getCapacidadDelMotor();
        contador++;
      } else {

        // si el vehiculo es una motocicleta
        if (vehiculo instanceof Motocicleta motocicleta) {
          suma += motocicleta.getTipoDeMotor();
          contador++;
        }
      }
    }

    // retorno el promedio
    return suma / contador;
  }

  /**
   * @return el promedio de la capacidad de carga de los camiones.
   */
  public double calcularPromedioDeCargaCamiones() {
    // suma
    double suma = 0;

    // contador
    int contador = 0;

    // ciclo para recorrer todos los vehiculos
    for (Vehiculo vehiculo : this.vehiculos) {

      // si el vehiculo es un camion
      if (vehiculo instanceof Camion camion) {
        suma += camion.getCapacidadDeCarga();
        contador++;
      }
    }

    // retorno el promedio
    return suma / contador;
  }

  /**
   * @return el vehiculo mas antiguo.
   */
  public Vehiculo getVehiculoMasAntiguo() {
    // vehiculo mas antiguo
    Vehiculo vehiculoMasAntiguo = null;

    // ciclo para recorrer todos los vehiculos
    for (Vehiculo vehiculo : this.vehiculos) {

      // si el vehiculo es mas antiguo
      if (vehiculoMasAntiguo == null || vehiculo.getAnio() < vehiculoMasAntiguo.getAnio()) {
        vehiculoMasAntiguo = vehiculo;
      }
    }

    // retorno el vehiculo mas antiguo
    return vehiculoMasAntiguo;
  }

  /**
   * @return el vehiculo mas nuevo.
   */
  public Vehiculo getVehiculoMasNuevo() {
    // vehiculo mas nuevo
    Vehiculo vehiculoMasNuevo = null;

    // ciclo para recorrer todos los vehiculos
    for (Vehiculo vehiculo : this.vehiculos) {

      // si el vehiculo es mas nuevo
      if (vehiculoMasNuevo == null || vehiculo.getAnio() > vehiculoMasNuevo.getAnio()) {
        vehiculoMasNuevo = vehiculo;
      }
    }

    // retorno el vehiculo mas nuevo
    return vehiculoMasNuevo;
  }

  /**
   * Obtiene el costo de operacion de un vehiculo.
   *
   * @param tipoVehiculo el tipo de vehiculo.
   * @param kilometros los kilometros recorridos.
   * @param costoLitroCombusible el costo del litro de combustible.
   * @return el costo de operacion de un vehiculo.
   */
  public double calcularCostoOperacionVehiculo(
      TipoVehiculo tipoVehiculo, double kilometros, double costoLitroCombusible) {

    // suma
    double suma = 0.0;

    // contador
    int contador = 0;

    // ciclo para recorrer todos los vehiculos
    for (Vehiculo vehiculo : this.vehiculos) {
      // solo automoviles
      if (vehiculo instanceof Automovil && tipoVehiculo == TipoVehiculo.AUTOMOVIL) {
        suma += vehiculo.getRendimiento();
        contador++;
      }

      // solo motocicletas
      if (vehiculo instanceof Motocicleta && tipoVehiculo == TipoVehiculo.MOTOCICLETA) {
        suma += vehiculo.getRendimiento();
        contador++;
      }

      // solo camiones
      if (vehiculo instanceof Camion camion) {

        // ligero
        if (camion.getTipoCamion() == TipoCamion.CAMION_LIGERO
            && tipoVehiculo == TipoVehiculo.CAMION_LIGERO) {
          suma += vehiculo.getRendimiento();
          contador++;
        }
        // pesado
        if (camion.getTipoCamion() == TipoCamion.CAMION_PESADO
            && tipoVehiculo == TipoVehiculo.CAMION_PESADO) {
          suma += vehiculo.getRendimiento();
          contador++;
        }
      }
    }

    // promedio
    double rendimientoPromedio = suma / contador;

    // retorno el promedio
    return (kilometros / rendimientoPromedio) * costoLitroCombusible;
  }
}

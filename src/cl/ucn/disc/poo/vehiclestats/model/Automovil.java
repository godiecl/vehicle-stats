// (c) 2024 Departamento de Ingenieria de Sistemas y Computacion
package cl.ucn.disc.poo.vehiclestats.model;

/**
 * Class Automovil.
 *
 * @author Departamento de Ingenieria de Sistemas y Computacion
 */
public final class Automovil extends Vehiculo {

  /** La capacidad del motor. */
  private final double capacidadDelMotor;

  /** El numero de puertas. */
  private final int numeroDePuertas;

  /** El tipo de combustible. */
  private final TipoCombustible tipoCombustible;

  /**
   * El constructor.
   *
   * @param marca del vehiculo.
   * @param modelo del vehiculo.
   * @param anio del vehiculo.
   * @param capacidadDelMotor del vehiculo.
   * @param numeroDePuertas del vehiculo.
   * @param tipoCombustible del vehiculo.
   * @param rendimiento del vehiculo.
   */
  public Automovil(
      String marca,
      String modelo,
      int anio,
      double capacidadDelMotor,
      int numeroDePuertas,
      TipoCombustible tipoCombustible,
      double rendimiento) {
    super(marca, modelo, anio, rendimiento);
    // TODO: agregar validaciones
    this.capacidadDelMotor = capacidadDelMotor;
    this.numeroDePuertas = numeroDePuertas;
    this.tipoCombustible = tipoCombustible;
  }

  /**
   * @return capacidadDelMotor.
   */
  public double getCapacidadDelMotor() {
    return this.capacidadDelMotor;
  }

  /**
   * @return numeroDePuertas.
   */
  public int getNumeroDePuertas() {
    return this.numeroDePuertas;
  }

  /**
   * @return tipoCombustible.
   */
  public TipoCombustible getTipoCombustible() {
    return this.tipoCombustible;
  }
}

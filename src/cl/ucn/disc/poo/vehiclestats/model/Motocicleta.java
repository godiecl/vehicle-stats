// (c) 2024 Departamento de Ingenieria de Sistemas y Computacion
package cl.ucn.disc.poo.vehiclestats.model;

/**
 * Class Motocicleta.
 *
 * @author Departamento de Ingenieria de Sistemas y Computacion
 */
public final class Motocicleta extends Vehiculo {

  /** Tipo de motor */
  private final double tipoDeMotor;

  /** Tipo de motocicleta. */
  private final TipoMotocicleta tipoMotocicleta;

  /**
   * The constructor.
   *
   * @param marca de la motocicleta.
   * @param modelo de la motocicleta.
   * @param anio de la motocicleta.
   * @param tipoDeMotor de la motocicleta.
   * @param tipoMotocicleta de la motocicleta.
   * @param rendimiento de la motocicleta.
   */
  public Motocicleta(
      final String marca,
      final String modelo,
      final int anio,
      final double tipoDeMotor,
      final TipoMotocicleta tipoMotocicleta,
      final double rendimiento) {
    super(marca, modelo, anio, rendimiento);
    // TODO: validacion
    this.tipoDeMotor = tipoDeMotor;
    this.tipoMotocicleta = tipoMotocicleta;
  }

  /**
   * @return tipoDeMotor.
   */
  public double getTipoDeMotor() {
    return this.tipoDeMotor;
  }

  /**
   * @return tipoMotocicleta.
   */
  public TipoMotocicleta getTipoMotocicleta() {
    return this.tipoMotocicleta;
  }
}

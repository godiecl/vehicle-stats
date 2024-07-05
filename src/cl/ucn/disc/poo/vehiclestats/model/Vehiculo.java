// (c) 2024 Departamento de Ingenieria de Sistemas y Computacion
package cl.ucn.disc.poo.vehiclestats.model;

/**
 * Clase Vehiculo.
 *
 * @author Programacion Orientada al Objeto.
 */
public abstract class Vehiculo {

  /** La marca. */
  private final String marca;

  /** El modelo. */
  private final String modelo;

  /** El anio. */
  private final int anio;

  /** El rendimiento. */
  private final double rendimiento;

  /**
   * El constructor de un vehiculo.
   *
   * @param marca del vehiculo.
   * @param modelo del vehiculo.
   * @param anio del vehiculo.
   * @param rendimiento del vehiculo.
   */
  public Vehiculo(String marca, String modelo, int anio, double rendimiento) {
    // TODO: agregar validaciones
    this.marca = marca;
    this.modelo = modelo;
    this.anio = anio;
    this.rendimiento = rendimiento;
  }

  /**
   * @return la marca.
   */
  public String getMarca() {
    return this.marca;
  }

  /**
   * @return el modelo.
   */
  public String getModelo() {
    return this.modelo;
  }

  /**
   * @return el anio.
   */
  public int getAnio() {
    return this.anio;
  }

  /**
   * @return rendimiento.
   */
  public double getRendimiento() {
    return this.rendimiento;
  }
}

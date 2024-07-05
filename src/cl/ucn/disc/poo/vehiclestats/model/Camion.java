// (c) 2024 Departamento de Ingenieria de Sistemas y Computacion
package cl.ucn.disc.poo.vehiclestats.model;

/**
 * Class Camion.
 *
 * @author Departamento de Ingenieria de Sistemas y Computacion
 */
public final class Camion extends Vehiculo {

  /** La capacidad de carga. */
  private final int capacidadDeCarga;

  /** El numero de ejes. */
  private final int numeroDeEjes;

  /** El tipo de camion. */
  private final TipoCamion tipoCamion;

  /** El tipo de remolque. */
  private final TipoRemolque tipoRemolque;

  /**
   * Constructor privado.
   *
   * @param marca del camion.
   * @param modelo del camion.
   * @param anio del camion.
   * @param capacidadDeCarga del camion.
   * @param numeroDeEjes del camion.
   * @param tipoCamion del camion.
   * @param tipoRemolque del camion.
   * @param rendimiento del camion.
   */
  private Camion(
      String marca,
      String modelo,
      int anio,
      int capacidadDeCarga,
      int numeroDeEjes,
      TipoCamion tipoCamion,
      TipoRemolque tipoRemolque,
      double rendimiento) {
    super(marca, modelo, anio, rendimiento);
    // TODO: agregar validaciones
    this.capacidadDeCarga = capacidadDeCarga;
    this.numeroDeEjes = numeroDeEjes;
    this.tipoCamion = tipoCamion;
    this.tipoRemolque = tipoRemolque;
  }

  /**
   * @return capacidadDeCarga.
   */
  public int getCapacidadDeCarga() {
    return this.capacidadDeCarga;
  }

  /**
   * @return numeroDeEjes.
   */
  public int getNumeroDeEjes() {
    return this.numeroDeEjes;
  }

  /**
   * @return tipoCamion.
   */
  public TipoCamion getTipoCamion() {
    return this.tipoCamion;
  }

  /**
   * @return tipoRemolque.
   */
  public TipoRemolque getTipoRemolque() {
    return this.tipoRemolque;
  }

  /**
   * Construir un camion ligero.
   *
   * @param marca del camion.
   * @param modelo del camion.
   * @param anio del camion.
   * @param capacidadDeCarga del camion.
   * @param numeroDeEjes del camion.
   * @param rendimiento del camion.
   * @return el camion pesado.
   */
  public static Camion construirCamionLigero(
      String marca,
      String modelo,
      int anio,
      int capacidadDeCarga,
      int numeroDeEjes,
      double rendimiento) {

    return new Camion(
        marca,
        modelo,
        anio,
        capacidadDeCarga,
        numeroDeEjes,
        TipoCamion.CAMION_LIGERO,
        null,
        rendimiento);
  }

  /**
   * Construir un camion pesado.
   *
   * @param marca del camion.
   * @param modelo del camion.
   * @param anio del camion.
   * @param capacidadDeCarga del camion.
   * @param numeroDeEjes del camion.
   * @param tipoRemolque del camion.
   * @param rendimiento del camion.
   * @return el camion pesado.
   */
  public static Camion construirCamionPesado(
      String marca,
      String modelo,
      int anio,
      int capacidadDeCarga,
      int numeroDeEjes,
      String tipoRemolque,
      double rendimiento) {

    return new Camion(
        marca,
        modelo,
        anio,
        capacidadDeCarga,
        numeroDeEjes,
        TipoCamion.CAMION_PESADO,
        TipoRemolque.valueOf(tipoRemolque),
        rendimiento);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return this.tipoCamion == TipoCamion.CAMION_LIGERO ? "CamionLigero" : "Camion Pesado";
  }
}

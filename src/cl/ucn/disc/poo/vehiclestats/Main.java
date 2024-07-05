// (c) 2024 Departamento de Ingenieria de Sistemas y Computacion
package cl.ucn.disc.poo.vehiclestats;

import cl.ucn.disc.poo.vehiclestats.model.Automovil;
import cl.ucn.disc.poo.vehiclestats.model.Camion;
import cl.ucn.disc.poo.vehiclestats.model.Motocicleta;
import cl.ucn.disc.poo.vehiclestats.model.TipoCombustible;
import cl.ucn.disc.poo.vehiclestats.model.TipoMotocicleta;
import cl.ucn.disc.poo.vehiclestats.model.TipoVehiculo;
import cl.ucn.disc.poo.vehiclestats.services.Sistema;
import cl.ucn.disc.poo.vehiclestats.utils.Archivo;

/**
 * Class Main.
 *
 * @author Departamento de Ingenieria de Sistemas y Computacion
 */
public final class Main {

  /**
   * The Main.
   *
   * @param args to use.
   */
  public static void main(String[] args) {

    // The sistema
    Sistema sistema = new Sistema();

    // Leer las lineas del archivo.
    java.util.List<String> lineas = Archivo.readLines("vehiculos.txt");

    // Imprimir las lineas.
    for (String linea : lineas) {

      // Imprimir la linea leida.
      // System.out.println("Linea leida: <" + linea + ">");

      // Separar los tokens de la linea por coma.
      String[] tokens = linea.split(",");

      // Obtener el tipo de vehiculo.
      String tipo = tokens[0];

      // Identificar el tipo de vehiculo.
      if (tipo.startsWith("A")) {
        sistema.agregarVehiculo(construirAutomovil(tokens));
      } else {
        if (tipo.startsWith("M")) {
          sistema.agregarVehiculo(construirMotocicleta(tokens));
        } else {
          if (tipo.startsWith("CamionLigero")) {
            sistema.agregarVehiculo(construirCamionLigero(tokens));
          } else {
            if (tipo.startsWith("CamionPesado")) {
              sistema.agregarVehiculo(construirCamionPesado(tokens));
            } else {
              System.out.println("Tipo de vehiculo desconocido");
            }
          }
        }
      }
    }

    // 1. Promedio de capacidad del motor.
    System.out.println(
        "Promedio de capacidad del motor: "
            + sistema.calcularPromedioDeCapacidadDelMotor()
            + "cc.");

    // 2. Promedio de capacidad de carga de camiones.
    System.out.println(
        "Promedio de capacidad de carga de camiones: "
            + sistema.calcularPromedioDeCargaCamiones()
            + " kg");

    // 3. Vehiculo mas antiguo.
    System.out.println("Vehiculo mas antiguo: " + sistema.getVehiculoMasAntiguo());

    // 4. Vehiculo mas nuevo.
    System.out.println("Vehiculo mas nuevo: " + sistema.getVehiculoMasNuevo());

    // 5. Costo estimado de operacion por 1000 kilometros.
    System.out.println("Costo estimado de operacion por 1000 kilometros (a 1.5 USD por litro): ");
    System.out.println(
        "  - Automoviles: "
            + sistema.calcularCostoOperacionVehiculo(TipoVehiculo.AUTOMOVIL, 1000, 1.5)
            + " USD");
    System.out.println(
        "  - Motocicletas: "
            + sistema.calcularCostoOperacionVehiculo(TipoVehiculo.MOTOCICLETA, 1000, 1.5)
            + " USD");
    System.out.println(
        "  - Camiones Ligeros: "
            + sistema.calcularCostoOperacionVehiculo(TipoVehiculo.CAMION_LIGERO, 1000, 1.5)
            + " USD");
    System.out.println(
        "  - Camiones Pesados: "
            + sistema.calcularCostoOperacionVehiculo(TipoVehiculo.CAMION_PESADO, 1000, 1.5)
            + " USD");
  }

  /**
   * Construir un automovil a partir de los tokens.
   *
   * @param tokens a utilizar.
   * @return the Automovil.
   */
  private static Automovil construirAutomovil(String[] tokens) {
    return new Automovil(
        tokens[1], // marca
        tokens[2], // modelo
        Integer.parseInt(tokens[3]), // anio
        Double.parseDouble(tokens[4]) * 1000, // capacidad
        Integer.parseInt(tokens[5]), // puertas
        TipoCombustible.valueOf(tokens[6]), // tipo de combustible
        Double.parseDouble(tokens[7]) // rendimiento
        );
  }

  /**
   * Construir una motocicleta a partir de los tokens.
   *
   * @param tokens a utilizar.
   * @return the Motocicleta.
   */
  private static Motocicleta construirMotocicleta(String[] tokens) {
    // remover los cc
    double tipoMotor = Double.parseDouble(tokens[4].replace("cc", ""));
    return new Motocicleta(
        tokens[1], // marca
        tokens[2], // modelo
        Integer.parseInt(tokens[3]), // anio
        tipoMotor, // tipo de motor
        TipoMotocicleta.valueOf(tokens[5]), // tipo de motocicleta
        Double.parseDouble(tokens[6]) // rendimiento
        );
  }

  /**
   * Construir un camion ligero a partir de los tokens.
   *
   * @param tokens a utilizar.
   * @return the Camion Ligero.
   */
  private static Camion construirCamionLigero(String[] tokens) {
    return Camion.construirCamionLigero(
        tokens[1], // marca
        tokens[2], // modelo
        Integer.parseInt(tokens[3]), // anio
        Integer.parseInt(tokens[4]), // capacidad de carga
        Integer.parseInt(tokens[5]), // numero de ejes
        Double.parseDouble(tokens[6]) // rendimiento
        );
  }

  /**
   * Construir un camion pesado a partir de los tokens.
   *
   * @param tokens a utilizar.
   * @return the Camion Pesado.
   */
  private static Camion construirCamionPesado(String[] tokens) {
    return Camion.construirCamionPesado(
        tokens[1], // marca
        tokens[2], // modelo
        Integer.parseInt(tokens[3]), // anio
        Integer.parseInt(tokens[4]), // capacidad de carga
        Integer.parseInt(tokens[5]), // numero de ejes
        tokens[6], // tipo de remolque
        Double.parseDouble(tokens[7]) // rendimiento
        );
  }
}

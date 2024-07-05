// (c) 2024 Departamento de Ingenieria de Sistemas y Computacion
package cl.ucn.disc.poo.vehiclestats.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clase que representa un archivo.
 *
 * @author Programacion Orientada al Objeto.
 */
public final class Archivo {

  /**
   * Metodo que lee las lineas de un archivo.
   *
   * @param filename nombre del archivo.
   * @return lista de lineas.
   */
  public static List<String> readLines(final String filename) {
    try {
      return Files.readAllLines(Paths.get(filename));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}

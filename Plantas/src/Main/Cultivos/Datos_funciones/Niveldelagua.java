package Main.Cultivos.Datos_funciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Niveldelagua {

    public static float obtenerniveldelagua(String archivo) {
        String linea;
        String[] valores;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            // Leer la primera línea para saltar los encabezados
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Suponiendo que los valores están separados por comas
                valores = linea.split(",");

                // Extraer la columna que contiene el promedio del nivel del agua
                double mean = Double.parseDouble(valores[4]); // Mean (columna 4)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir un número: " + e.getMessage());
        }
        return 0; // Retorna 0 en caso de error o sin datos
    }
}

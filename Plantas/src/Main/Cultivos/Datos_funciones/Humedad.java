package Main.Cultivos.Datos_funciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Humedad {
    public static double obtenerhumedadpromedio(String archive){
        String linea;
        String[] valores;
        try (BufferedReader br = new BufferedReader(new FileReader(archive))) {
            // Leer la primera línea para saltar los encabezados
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Suponiendo que los valores están separados por comas
                valores = linea.split(",");

                // Extraer la columna que contiene el promedio de la humedad
                double mean = Double.parseDouble(valores[1]); // Mean (columna 1)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir un número: " + e.getMessage());
        }
        return 0; // Retorna 0 en caso de error o sin datos
    }
}


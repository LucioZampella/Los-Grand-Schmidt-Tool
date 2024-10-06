package Main.Cultivos.Datos_funciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Estacion {

    public static String getseason(String archivo){
        String linea;
        String[] valores;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            // Leer la primera línea para saltar los encabezados
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Suponiendo que los valores están separados por comas
                valores = linea.split(",");

                // Extraer la columna que contiene el promedio de la estacionn
                double mean = Double.parseDouble(valores[5]); // Mean (columna 5)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir un número: " + e.getMessage());
        }
        return ""; // Retorna "" en caso de error o sin datos
    }
    }
}

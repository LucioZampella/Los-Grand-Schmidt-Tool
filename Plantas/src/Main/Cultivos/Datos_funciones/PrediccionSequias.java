package Main.Cultivos.Datos_funciones;

public class PrediccionSequias {

    public static boolean predecirsequia(double precipitacionPromedio, double temperaturaPromedio, double humedadSuelo, String estacionDelAño) {
        final double UMBRAL_PRECIPITACION_BAJA = 50.0; // mm de lluvia al mes
        final double UMBRAL_TEMPERATURA_ALTA = 30.0;   // Grados Celsius
        final double UMBRAL_HUMEDAD_BAJA = 30.0;       // % de humedad en el suelo

        // Condición 1: Precipitación baja
        boolean esPrecipitacionBaja = precipitacionPromedio < UMBRAL_PRECIPITACION_BAJA;

        // Condición 2: Temperatura alta
        boolean esTemperaturaAlta = temperaturaPromedio > UMBRAL_TEMPERATURA_ALTA;

        // Condición 3: Humedad del suelo baja
        boolean esHumedadBaja = humedadSuelo < UMBRAL_HUMEDAD_BAJA;

        // Condición 4: Estación del año
        boolean esVerano = estacionDelAño.equalsIgnoreCase("verano");

        // Reglas simples: si la precipitación es baja, la temperatura es alta y la humedad es baja, puede haber sequía.
        if (esPrecipitacionBaja && esTemperaturaAlta && esHumedadBaja) {
            return true; // Alta probabilidad de sequía
        }

        // Si es verano y la precipitación es baja, también hay riesgo
        if (esPrecipitacionBaja && esVerano) {
            return true;
        }

        // Si ninguna de las condiciones de riesgo se cumple, no hay sequía
        return false;
    }

    public static void main(String[] args) {
        // Ejemplo de uso:
        double precipitacionPromedio = 30.0; // mm de lluvia
        double temperaturaPromedio = 35.0;  // Grados Celsius
        double humedadSuelo = 20.0;         // % de humedad en el suelo
        String estacionDelAño = "verano";

        boolean haySequía = predecirsequia(precipitacionPromedio, temperaturaPromedio, humedadSuelo, estacionDelAño);

        if (haySequía) {
            System.out.println("Hay una alta probabilidad de sequía.");
        } else {
            System.out.println("No se espera sequía.");
        }
    }

        // Función para predecir si habrá una inundación
        public static boolean predecirInundacion(double precipitacion, double nivelAgua, double humedadSuelo) {
            // Definir umbrales
            double umbralPrecipitacion = 600;  // En milímetros
            double umbralNivelAgua = 70;       // En porcentaje del nivel máximo
            double umbralHumedadSuelo = 80;    // En porcentaje de la capacidad de campo

            // Condiciones que incrementan el riesgo de inundación
            if (precipitacion > umbralPrecipitacion && nivelAgua > umbralNivelAgua && humedadSuelo > umbralHumedadSuelo) {
                return true;  // Alta probabilidad de inundación
            } else {
                return false; // No hay riesgo significativo de inundación
            }
        }
    }



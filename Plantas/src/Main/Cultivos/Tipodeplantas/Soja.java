package Main.Cultivos.Tipodeplantas;

import Main.Cultivos.Datos_funciones.Cultivo;
import Main.Cultivos.Datos_funciones.Humedad;
import Main.Cultivos.Datos_funciones.Precipitaciones;
import Main.Cultivos.Datos_funciones.Temperature;

import static Main.Cultivos.Datos_funciones.Estacion.getseason;
import static Main.Cultivos.Datos_funciones.Humedaddelsuelo.obtenerpromediohumedadsuelo;
import static Main.Cultivos.Datos_funciones.Niveldelagua.obtenerniveldelagua;
import static Main.Cultivos.Datos_funciones.PrediccionSequias.predecirInundacion;
import static Main.Cultivos.Datos_funciones.PrediccionSequias.predecirsequia;
//ejemplo de como se implementaria con los distintos cultivos
//este es un ejemplo general, en la implementacion cada estadistica de cada funcion
//sera mas especifica

public class Soja extends Cultivo {
    @Override
    protected String stadistic(String archive) {
        float tempeturestadistic = tempeture(archive);
        float humedadstadistic = humedad(archive);
        float precipitacionstadistic = precipitacion(archive);
        String message = "";
        String estacion = getseason(archive);
        float humedaddelsuelo = obtenerpromediohumedadsuelo(archive);
        float niveldelagua = obtenerniveldelagua(archive);

        float finalstadistic = tempeturestadistic + humedadstadistic + precipitacionstadistic;
        if (predecirsequia(precipitacionstadistic, tempeturestadistic, humedaddelsuelo, estacion)) {
            message = "Tu zona podria presentar una sequia";
        }
        if (predecirInundacion(precipitacionstadistic, niveldelagua, humedaddelsuelo)) {
            message = "Tu zona podria presentar una inundación";
        }
        if (finalstadistic == 300) {
            message = "Las condiciones son perfectas para el cultivo de soja";
        }
        if (tempeturestadistic == 75 &&humedadstadistic+precipitacionstadistic>100) {
            message="Las condiciones son optimas para el cultivo de soja";
        }
        if(tempeturestadistic == 75 && humedadstadistic+precipitacionstadistic<100) {
            message= "Las condiciones son optimas, pero deberia optimizar el sistema de riego";
        }
        if(finalstadistic==100){
            message="Las condiciones no son optimas para el cultivo de soja";
        }else{
            message="Las condiciones no son optimas para el cultivo de soja";
        }



        return message;
    }

    //creo una funcion donde determinada temperatura, si es la temperatura perfecta devuelve el maximo de estadistica
    //es decir 100
    public float tempeture(String archivo) {
        double tempeture = Temperature.obtenerTemperaturaPromedio(archivo);

        float porcentage = 0;
        // la temperatura es perfecta para el cultivo
        if (tempeture <= 30 && tempeture >= 25) {
            porcentage = 100;
        }//la temperatura es apta para el cultivo
        if (tempeture >= 30 && tempeture <= 35) {
            porcentage = 75;
        }
        if (tempeture >= 20 && tempeture <= 30) {
            porcentage = 75;
        }//la temperatura no es optima pero no es extrema
        if (tempeture >= 15 && tempeture <= 20) {
            porcentage = 50;
        }//la temperatura no es optima para el cultivo
        if (tempeture > 35 && tempeture < 15) {
            porcentage = 25;
        }
        return porcentage;
    }

    public float humedad(String archive) {
        double humedad = Humedad.obtenerhumedadpromedio(archive);
        float porcentage = 0;
        if (humedad <= 70 && humedad >= 60) {
            porcentage = 100;
        }
        if (humedad > 70 && humedad <= 80) {
            porcentage = 75;
        }
        if (humedad >= 50 && humedad <= 80) {
            porcentage = 75;
        }
        if (humedad < 50) {
            porcentage = 25;
        }
        return porcentage;
    }

    public float precipitacion(String archivo) {
        double precipitaciones = Precipitaciones.obtenerpromedioprecipitaciones(archivo);
        float porcentage = 0;
        if (precipitaciones <= 800 && precipitaciones >= 500) {
            porcentage = 100;
        } else {
            porcentage = 50;
        }
        return porcentage;
    }
}

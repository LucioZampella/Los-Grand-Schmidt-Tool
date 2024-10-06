package Main.Cultivos.Datos_funciones;
//Creo una solucion general usando polimorfismo y clases abstractas
//Supongo que los datos estan guardados en una archivo CSV de las siguientes carcateristicas
//medicion_de_temperatura,medicion_de_humedad,medicion_de_precipitaciones,humedad_del_suelo,Nivel_del_agua,estacion
public abstract class Cultivo {
    protected abstract String stadistic(String archivo);
}



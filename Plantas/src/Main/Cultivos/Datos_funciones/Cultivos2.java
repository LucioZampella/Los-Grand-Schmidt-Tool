package Main.Cultivos.Datos_funciones;

class Cultivos2 {
     Main.Cultivos.Datos_funciones.Cultivo Cultivo;

     void setCultivo(Cultivo Cultivo){
         this.Cultivo = Cultivo;
     }
     void checkoutStadistic(String archive){
         System.out.println(Cultivo.stadistic(archive));

     }
}

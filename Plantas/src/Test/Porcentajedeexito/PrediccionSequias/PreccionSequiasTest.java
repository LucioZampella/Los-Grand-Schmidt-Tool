package Test.Porcentajedeexito.PrediccionSequias;
import static Main.Cultivos.Datos_funciones.PrediccionSequias.predecirsequia;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PreccionSequiasTest{

    @org.junit.Test
    public void testsequia() {
        double precipitacion = 30;
        double tempeture = 40;
        double humety=20;

        assertTrue(predecirsequia(precipitacion,tempeture,humety,"verano"));
    }

}

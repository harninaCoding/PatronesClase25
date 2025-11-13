package test.goverment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.data.being.Adult;
import model.data.being.Being;
import model.data.being.Young;
import model.data.goverment.Goverment;

public class BecomeOlderTest {

    @Test
    void testBecomeOlder() {
        // Crea instancias de Being y clases específicas para el test
        Being youngBeing = new Being();  // Supongamos que YoungBeing es una subclase de Being
        Being youngBeing2 = new Being(30);  // Supongamos que YoungBeing es una subclase de Being

        // Crea las listas source y destination
        List<Being> source = new ArrayList<>();
        source.add(youngBeing);
        source.add(youngBeing2);

        int adultAge=18; 
        for (int i = 0; i < adultAge; i++) {
        	youngBeing2.live(youngBeing2.getVitalNecesity());
        }

        List<Being> destination = new ArrayList<>();

        // Crea una instancia del controlador

//        State classUnderTest = new State(0); // reemplaza con la clase que contiene becomeOlder

        // Verifica los resultados
        assertTrue(destination.size()==1, "El adulto debería haber sido movido a 'destination'");
        assertTrue(source.size()==1, "El adulto debería haber sido eliminado de 'source'");
        assertTrue(source.contains(youngBeing), "El joven debería permanecer en 'source'");
        assertFalse(source.contains(youngBeing2), "El joven no debería estar en 'destination'");
    }
}

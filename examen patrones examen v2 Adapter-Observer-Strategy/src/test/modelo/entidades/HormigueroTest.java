package test.modelo.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.adapter.HormigaAdapter;
import modelo.entidades.Hormiguero;

class HormigueroTest {

    @Test
    void test(){
        Hormiguero hormiguero=new Hormiguero(new HormigaAdapter());
        hormiguero.funciona();
        assertEquals(hormiguero.cantidadHormigasTotal, hormiguero.getHormigas().size());
        long count = hormiguero.getHormigas().stream().filter((hormiga)->{return hormiga.isGuerrera();}).count();
        int hormigasGuerrerasEnPaz=0;
        assertEquals(hormigasGuerrerasEnPaz, count);
    }
}
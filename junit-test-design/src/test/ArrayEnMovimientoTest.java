package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import arrays.ArrayEnMovimiento;

public class ArrayEnMovimientoTest {

    @Test
    public void testMoverUno_CasoNormal() {
        ArrayEnMovimiento aem = new ArrayEnMovimiento();
        int[] entrada = {10, 20, 30, 40};
        int[] esperado = {-1, 10, 20, 30};
        assertArrayEquals(esperado, aem.moverUno(entrada));
    }

    @Test
    public void testMoverUno_UnSoloElemento() {
        ArrayEnMovimiento aem = new ArrayEnMovimiento();
        int[] entrada = {5};
        int[] esperado = {-1};
        assertArrayEquals(esperado, aem.moverUno(entrada));
    }

    @Test
    public void testMoverUno_ArrayVacio() {
        ArrayEnMovimiento aem = new ArrayEnMovimiento();
        int[] entrada = {};
        int[] esperado = {};
        assertArrayEquals(esperado, aem.moverUno(entrada));
    }

    @Test
    public void testMoverUno_Null() {
        ArrayEnMovimiento aem = new ArrayEnMovimiento();
        int[] resultado = aem.moverUno(null);
        assertEquals(0, resultado.length);
    }
}

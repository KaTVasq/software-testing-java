package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import arrays.ArrayMultiplica;

public class ArrayMultiplicaTest {

    @Test
    public void testMultiplica_MismoTamano() {
        ArrayMultiplica am = new ArrayMultiplica();
        int[] a1 = {2, 3, 4};
        int[] a2 = {5, 6, 7};
        int[] esperado = {10, 18, 28};
        assertArrayEquals(esperado, am.multiplica(a1, a2));
    }

    @Test
    public void testMultiplica_PrimerMasLargo() {
        ArrayMultiplica am = new ArrayMultiplica();
        int[] a1 = {2, 3, 4, 5};
        int[] a2 = {10, 20};
        int[] esperado = {20, 60, 4, 5}; // min=2, resto copia de a1
        assertArrayEquals(esperado, am.multiplica(a1, a2));
    }

    @Test
    public void testMultiplica_SegundoMasLargo() {
        ArrayMultiplica am = new ArrayMultiplica();
        int[] a1 = {1, 2};
        int[] a2 = {5, 6, 7};
        int[] esperado = {5, 12, 7}; // min=2, resto copia de a2
        assertArrayEquals(esperado, am.multiplica(a1, a2));
    }

    @Test
    public void testMultiplica_ArrayVacio() {
        ArrayMultiplica am = new ArrayMultiplica();
        int[] a1 = {};
        int[] a2 = {3, 4, 5};
        int[] esperado = {3, 4, 5};
        assertArrayEquals(esperado, am.multiplica(a1, a2));
    }

    @Test
    public void testMultiplica_Null() {
        ArrayMultiplica am = new ArrayMultiplica();
        assertEquals(0, am.multiplica(null, new int[]{1,2}).length);
    }
}

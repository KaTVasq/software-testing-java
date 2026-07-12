package tests;

import org.junit.jupiter.api.Test;
import Calc.MutCalculate;

import java.lang.reflect.Method;

class testMutCalc {

    @Test
    void testMutantesDetalladoConTipo() throws Exception {
        MutCalculate mc = new MutCalculate();
        
     // ------------------------------------------------------
     // Explicación de siglas de cobertura:
     // CBC  -> Cobertura de Caso Base
     // PPC  -> Caminos Primarios
     // PEC  -> Pares de Aristas
     // ------------------------------------------------------
        Object[][] tests = {
        	    // NombreTest, Tipo, month1, day1, month2, day2, year, ResultadoEsperado
        	    {"MismoMes", "CBC", 3, 10, 3, 15, 2024, 5},                         // Días dentro del mismo mes
        	    {"FebreroNoBisiesto", "CBC/PPC", 2, 10, 3, 5, 2023, 23},            // Febrero año no bisiesto, sin meses intermedios
        	    {"FebreroBisiesto", "CBC/PPC", 2, 10, 3, 5, 2024, 24},              // Febrero año bisiesto, sin meses intermedios
        	    {"EneroMarzoNoBisiesto", "PPC", 1, 10, 3, 5, 2023, 54},             // Enero a marzo, año no bisiesto (incluye febrero)
        	    {"EneroMarzoBisiesto", "PPC", 1, 10, 3, 5, 2024, 55},               // Enero a marzo, año bisiesto (incluye febrero bisiesto)
        	    {"MesesConsecutivos", "PEC", 4, 5, 6, 10, 2023, 66},                // Meses consecutivos (abril a junio) para pares de aristas
        	    {"BisiestoConBucle", "PEC", 1, 1, 4, 1, 2024, 91}                   // Año bisiesto con bucle (enero a abril)
        	};

        for (int mt = 1; mt <= 11; mt++) {
            String metodo = "calMt" + mt;
            Method m = MutCalculate.class.getMethod(metodo, int.class, int.class, int.class, int.class, int.class);

            System.out.println("===== Probando Mutante " + metodo + " =====");

            int erroresDetectados = 0;

            for (Object[] test : tests) {
                String nombreTest = (String) test[0];
                String tipoTest = (String) test[1];
                int mes1 = (int) test[2];
                int dia1 = (int) test[3];
                int mes2 = (int) test[4];
                int dia2 = (int) test[5];
                int año = (int) test[6];
                int esperado = (int) test[7];

                int resultado = (int) m.invoke(mc, mes1, dia1, mes2, dia2, año);

                if (resultado == esperado) {
                    System.out.println("✅ " + nombreTest + " (" + tipoTest + "): PASÓ");
                } else {
                    System.out.println("❌ " + nombreTest + " (" + tipoTest + "): FALLÓ | esperado: " + esperado + ", obtenido: " + resultado);
                    erroresDetectados++;
                }
            }

            System.out.println(">>> Mutante " + metodo + " detectó errores en " + erroresDetectados + " test(s)\n");
        }
    }
}
